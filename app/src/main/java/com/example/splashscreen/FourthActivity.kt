package com.example.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FourthActivity : AppCompatActivity() {

     lateinit var databaseReference1 :DatabaseReference
     lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        val register= findViewById<Button>(R.id.btnback)
        val signInButton=findViewById<Button>(R.id.loginButton)
        val emailId = findViewById<TextInputEditText>(R.id.UserEditText)
        val passWord =findViewById<TextInputEditText>(R.id.passWordEditText)


        auth=FirebaseAuth.getInstance();



        register.setOnClickListener(){
            val intentRegister=Intent(this,thirdActivity::class.java)
            startActivity(intentRegister)
        }

        signInButton.setOnClickListener(){
            //Take ref till  users
            var emailId=emailId.text.toString()
            var passWord= passWord.text.toString()
            if(emailId.isNotEmpty() && passWord.isNotEmpty()){
                login(emailId,passWord)

                val intentHome=Intent(this,homeActivity::class.java)
                startActivity(intentHome)
            }else{
                Toast.makeText(this,"Please enter your username / password",Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun login(emailId: String, passWord: String) {

        auth.signInWithEmailAndPassword(emailId, passWord)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    var intent=Intent(this,homeActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this,"Wrong!!!!",Toast.LENGTH_SHORT).show()
                }
            }

    }


}
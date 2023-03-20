package com.example.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class thirdActivity : AppCompatActivity() {


    lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)


        val signUpbtn=findViewById<Button>(R.id.button2)
        val etName= findViewById<EditText>(R.id.textInputEditText)
        val etUN= findViewById<EditText>(R.id.textInputEditText4)
        val etPass= findViewById<EditText>(R.id.textInputEditText2)
        val etMobNo=findViewById<EditText>(R.id.textInputEditText5)
        val etEmail= findViewById<EditText>(R.id.textInputEditText3)

        signUpbtn.setOnClickListener{
            val name=etName.text.toString()
            val uname=etUN.text.toString()
            val pass=etPass.text.toString()
            val  mob=etMobNo.text.toString()
            val email=etEmail.text.toString()


            val user = User(name,uname,email,pass,mob)
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(uname).setValue(user).addOnSuccessListener {

                etName.text.clear()
                Toast.makeText(this,"User Registered",Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(this,"failed to register",Toast.LENGTH_SHORT).show()
            }


        }



    }
}
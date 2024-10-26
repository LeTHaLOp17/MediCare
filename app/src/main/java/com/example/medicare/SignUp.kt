package com.example.medicare

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.fragment_sign_up)

        var signinBtn = findViewById<TextView>(R.id.signin)

        signinBtn.setOnClickListener {
            // Create an Intent to start the SignUp activity
            val intent = Intent(this@SignUp, LoginFragment::class.java)
            // Start the SignUp activity
            startActivity(intent)
            finish()
        }
    }
}
package com.example.medicare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class LoginFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.fragment_login)
        var signupBtn = findViewById<Button>(R.id.signup)

        signupBtn.setOnClickListener {
            // Create an Intent to start the SignUp activity
            val intent = Intent(this@LoginFragment, SignUp::class.java)
            // Start the SignUp activity
            startActivity(intent)
            finish()
        }
    }
}

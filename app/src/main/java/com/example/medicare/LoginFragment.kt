package com.example.medicare

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class LoginFragment : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.fragment_login)
        var signupBtn = findViewById<Button>(R.id.signup)
        var loginBtn = findViewById<Button>(R.id.login)
        var skipBtn = findViewById<TextView>(R.id.skipp)

        signupBtn.setOnClickListener {
            // Create an Intent to start the SignUp activity
            val intent = Intent(this@LoginFragment, SignUpActivity::class.java)
            // Start the SignUp activity
            startActivity(intent)
            finish()
        }

        loginBtn.setOnClickListener {
            // Create an Intent to start the SignUp activity
            val intent = Intent(this@LoginFragment, HomePage::class.java)
            // Start the SignUp activity
            startActivity(intent)
            finish()
        }
        skipBtn.setOnClickListener {
            // Create an Intent to start the SignUp activity
            val intent = Intent(this@LoginFragment, YourLocation::class.java)
            // Start the SignUp activity
            startActivity(intent)
        }
    }
}

    package com.example.medicare

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler as OsHandler

    class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        OsHandler().postDelayed({
            val intent = Intent(this@MainActivity, LoginFragment::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
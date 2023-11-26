package com.sigiey.teamapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var signInButton: MaterialButton = this.findViewById(R.id.sign)
        signInButton.setOnClickListener{
            val intent = Intent(this, SignInActivity::class.java)
            this.startActivity(intent)
        }
        var registerButton: MaterialButton = this.findViewById(R.id.register)
        registerButton.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            this.startActivity(intent)
        }
    }
}
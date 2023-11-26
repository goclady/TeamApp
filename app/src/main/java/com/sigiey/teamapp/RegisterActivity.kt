package com.sigiey.teamapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        var loginButton: TextView= this.findViewById(R.id.login)
        loginButton.setOnClickListener{
            val intent = Intent(this, SignInActivity::class.java)
            this.startActivity(intent)
        }

        var signUpBtn: MaterialButton = this.findViewById(R.id.sign)

        val nameEdt: TextInputLayout = findViewById(R.id.name)
        val bNameEdt: TextInputLayout = findViewById(R.id.bName)
        val phoneEdt: TextInputLayout = findViewById(R.id.phone)
        val emailEdt: TextInputLayout = findViewById(R.id.email)
        val passwordEdt: TextInputLayout = findViewById(R.id.password)

        signUpBtn.setOnClickListener {
            val nameEntered: String = nameEdt.editText?.text.toString()
            val businessNameEntered: String = bNameEdt.editText?.text.toString()
            val phoneEnteredStr: String = phoneEdt.editText?.text.toString()
            val userEmailEntered: String = emailEdt.editText?.text.toString()
            val passwordEntered: String = passwordEdt.editText?.text.toString()

            var message = ""

            if (nameEntered.isBlank()) {
                message = "Please enter your name"
            } else if (businessNameEntered.isBlank()) {
                message = "Please enter your business name"
            } else if (phoneEnteredStr.isBlank() || !phoneEnteredStr.all { it.isDigit() }) {
                message = "Please enter a valid phone number"
            } else if (!userEmailEntered.matches(Regex("^[a-zA-Z0-9.a-zA-Z0-9.!#$%&'*+-/=?^_`{|}~]+@[a-zA-Z0-9]+\\.[a-zA-Z]+"))) {
                message = "Please enter a valid email address"
            } else if (passwordEntered.isBlank()) {
                message = "Password cannot be empty"
            } else if (passwordEntered.length < 8) {
                message = "Password must be at least 8 characters long"
            } else {
                message = "Signed Up Successfully"
              
            }


            Snackbar
                .make(
                    findViewById(R.id.sign),
                    message,
                    Snackbar.LENGTH_LONG
                )
                .show()
        }


    }
}

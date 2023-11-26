package com.sigiey.teamapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)


        var registerButton: TextView = this.findViewById(R.id.register)
        registerButton.setOnClickListener{            val intent = Intent(this,
            RegisterActivity::class.java)
            this.startActivity(intent)
        }
        var frgtPasswordButton: Button = this.findViewById(R.id.forgotPasswordBtn)
        frgtPasswordButton.setOnClickListener{
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            this.startActivity(intent)
        }

        var signInBtn: MaterialButton = this.findViewById(R.id.signInButton)

        val emailEdt: TextInputLayout = findViewById(R.id.email)
        val passwordEdt: TextInputLayout = findViewById(R.id.password)


        signInBtn.setOnClickListener {

            val userEmailEntered: String = emailEdt.editText?.text.toString()
            val passwordEntered: String = passwordEdt.editText?.text.toString()

            var message = ""

            if (!userEmailEntered.matches(Regex("^[a-zA-Z0-9.a-zA-Z0-9.!#$%&'*+-/=?^_`{|}~]+@[a-zA-Z0-9]+\\.[a-zA-Z]+"))) {
                message = "Please enter a valid email address"
            } else if (passwordEntered.isEmpty()) {
                message = "Password cannot be empty"
            } else if (passwordEntered.length < 8) {
                message = "Password must be at least 8 characters long"
            } else {
                message = "Signed in Successfully"
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }


            Snackbar
                .make(
                    findViewById(R.id.signInButton),
                    message,
                    Snackbar.LENGTH_LONG
                )
                .show()

        }

    }
}
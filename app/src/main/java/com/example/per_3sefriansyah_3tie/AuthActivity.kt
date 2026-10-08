package com.example.per_3sefriansyah_3tie

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class AuthActivity : AppCompatActivity() {

    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_auth)

        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {

            val username = edtUsername.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            if (username == password && username.isNotEmpty()) {

                val sharedPref =
                    getSharedPreferences("user_pref", MODE_PRIVATE)

                val editor = sharedPref.edit()

                editor.putBoolean("isLogin", true)
                editor.putString("username", username)

                editor.apply()

                val intent =
                    Intent(this, MainActivity::class.java)

                startActivity(intent)
                finish()

            } else {

                AlertDialog.Builder(this)
                    .setTitle("Login Gagal")
                    .setMessage("Silahkan coba lagi")
                    .setPositiveButton("OK", null)
                    .show()
            }
        }
    }
}
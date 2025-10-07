package com.pdm.tela9

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // -NAVEGAÇÃO PARA A TELA DE REGISTRO ---
        val textSignUp = findViewById<TextView>(R.id.textSignUp)
        textSignUp.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


        val emailInput = findViewById<EditText>(R.id.editEmail)
        val passwordInput = findViewById<EditText>(R.id.editPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)

        // botão de login.
        loginButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            // 4. Verificar se algum dos campos está vazio.
            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Por favor, insira um e-mail válido.", Toast.LENGTH_SHORT).show()
            }else if (passwordInput.length()<8){
                Toast.makeText(this,"A senha deve possuir 8 caracteres",Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show()
                // lógica de login real (ex: verificar com um banco de dados).
            }
        }
    }
}
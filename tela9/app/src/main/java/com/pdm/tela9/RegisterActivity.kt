package com.pdm.tela9

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // --- PARTE 1: TORNANDO O "LOGIN HERE" FUNCIONAL ---

        // 1. Encontrar o TextView "Login here" pelo seu ID.
        val textLoginHere = findViewById<TextView>(R.id.textLoginHere)

        // 2. Configurar o que acontece ao clicar nele.
        textLoginHere.setOnClickListener {
            // A função finish() fecha a activity atual (RegisterActivity).
            // Como a MainActivity ainda está "aberta" por baixo, o usuário
            // simplesmente voltará para ela.
            finish()
        }

        // --- PARTE 2: ADICIONANDO A VALIDAÇÃO DE CAMPOS E E-MAIL --- 📧

        // 1. Pegar as referências dos campos de texto e do botão.
        val fullNameInput = findViewById<EditText>(R.id.editFullName)
        val emailInput = findViewById<EditText>(R.id.editEmailRegister)
        val passwordInput = findViewById<EditText>(R.id.editPasswordRegister)
        val registerButton = findViewById<Button>(R.id.btnRegister)

        // 2. Configurar o que acontece ao clicar no botão "REGISTER".
        registerButton.setOnClickListener {
            // 3. Pegar o texto atual dos campos.
            val fullName = fullNameInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            // 4. Iniciar a validação.
            if (fullName.isBlank() || email.isBlank() || password.isBlank()) {
                // Primeiro, checamos se algum campo está vazio.
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()

            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                // Depois, checamos se o e-mail tem um formato válido.
                // Patterns.EMAIL_ADDRESS é um validador padrão do Android, muito confiável.
                Toast.makeText(this, "Por favor, insira um e-mail válido.", Toast.LENGTH_SHORT).show()

            } else {
                // Se tudo estiver correto, mostramos uma mensagem de sucesso.
                Toast.makeText(this, "Registro efetuado com sucesso!", Toast.LENGTH_SHORT).show()
                // Aqui você adicionaria a lógica para salvar o usuário e, talvez,
                // navegar para a tela principal do app.
                // Por exemplo, poderíamos voltar para a tela de login:
                finish()
            }
        }
    }
}
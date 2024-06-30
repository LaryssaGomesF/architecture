package com.example.architecture.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.architecture.data.Repository
import com.example.architecture.databinding.ActivityLoginBinding
import com.example.architecture.utils.Factory
import com.example.architecture.viewModel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by lazy {
        val repository = Repository()
        Factory(repository).create(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListeners()
        setUpObservers()
    }

    private fun setUpListeners() {
        binding.apply {
            buttonLogin.setOnClickListener {
                viewModel.doLogin(
                    email = editTextLogin.text.toString(),
                    password = editTextPassword.text.toString()
                )
            }
        }
    }

    private fun setUpObservers() {
        viewModel.loginResult.observe(this) {
            if (it) successLogin() else errorLogin()
        }
    }


    private fun successLogin() {
        Toast.makeText(this, "Success Login", Toast.LENGTH_SHORT).show()
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun errorLogin() {
        binding.apply {
            editTextLogin.error = "An error occur while trying to log in"
            editTextPassword.error = "An error occur while trying to log in"
        }
    }
}
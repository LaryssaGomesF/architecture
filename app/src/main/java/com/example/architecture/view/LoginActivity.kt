package com.example.architecture.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.architecture.presenter.LoginPresenter
import com.example.architecture.contracts.LoginContract
import com.example.architecture.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), LoginContract.LoginView {

    private lateinit var binding: ActivityLoginBinding

    override lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = LoginPresenter(this)

        binding.apply {
            buttonLogin.setOnClickListener {
                val login = editTextLogin.text.toString()
                val password = editTextPassword.text.toString()
                presenter.isLoginValid(login, password)
            }
        }
    }

    override fun displayErrorMessage() {
       binding.apply {
           editTextLogin.error = "An error occur while trying to log in"
           editTextPassword.error = "An error occur while trying to log in"
       }
    }

    override fun displaySucessToast() {
        Toast.makeText(this, "Success Login", Toast.LENGTH_SHORT).show()
    }

    override fun startHomeActivity() {
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)
    }
}
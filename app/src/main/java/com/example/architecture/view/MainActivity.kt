package com.example.architecture.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.architecture.data.Repository
import com.example.architecture.databinding.ActivityMainBinding
import com.example.architecture.utils.Factory
import com.example.architecture.viewModel.LoginViewModel
import com.example.architecture.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by lazy {
        val repository = Repository()
        Factory(repository).create(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListeners()
        setUpObservers()
        viewModel.getCount()
    }

    private fun setUpListeners() {
        binding.apply {
            buttonSubtract.setOnClickListener {
                viewModel.decrementValue()
            }
            buttonAdd.setOnClickListener {
                viewModel.incrementValue()
            }
        }
    }

    private fun setUpObservers() {
        viewModel.counter.observe(this) {
            binding.textView.text = it
        }
    }

}
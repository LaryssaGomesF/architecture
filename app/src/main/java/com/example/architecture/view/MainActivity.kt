package com.example.architecture.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.architecture.contracts.ContractInterface
import com.example.architecture.databinding.ActivityMainBinding
import com.example.architecture.presenter.MainPresenter

class MainActivity : AppCompatActivity(), ContractInterface.MainView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: ContractInterface.MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenter(this)
        presenter.initValue()
        setListener()
    }

    override fun updateViewData() {
        binding.apply {
            textView.text = presenter.getCounter()
        }
    }

    override fun initValue() {
        binding.apply {
            textView.text = presenter.getCounter()
        }
    }

    private fun setListener() {
        binding.apply {
            buttonAdd.setOnClickListener {
                presenter.incrementValue()
            }
            buttonSubtract.setOnClickListener {
                presenter.decrementValue()
            }
        }
    }
}
package com.example.architecture.presenter

import com.example.architecture.contracts.ContractInterface
import com.example.architecture.model.MainActivityModel

class MainPresenter(private val view: ContractInterface.MainView) : ContractInterface.MainPresenter {

    private var model = MainActivityModel()

    override fun incrementValue() {
        model.incrementCounter()
        view.updateViewData()
    }

    override fun decrementValue() {
        model.decrementCounter()
        view.updateViewData()
    }

    override fun initValue() {
        view.initValue()
    }

    override fun getCounter(): String = model.getCounter().toString()
}
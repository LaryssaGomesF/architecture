package com.example.architecture.contracts

interface ContractInterface {

    interface MainView {
        fun updateViewData()
        fun initValue()
    }

    interface MainPresenter {
        fun incrementValue()
        fun decrementValue()
        fun initValue()
        fun getCounter(): String
    }

    interface MainModel {
        fun getCounter(): Int
        fun incrementCounter()
        fun decrementCounter()
    }

}
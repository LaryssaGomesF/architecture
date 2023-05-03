package com.example.architecture.model

import com.example.architecture.contracts.ContractInterface

class MainActivityModel: ContractInterface.MainModel {

    private var mCounter = 10

    override fun getCounter(): Int  = mCounter

    override fun incrementCounter() {
       mCounter++
    }

    override fun decrementCounter() {
        mCounter--
    }
}
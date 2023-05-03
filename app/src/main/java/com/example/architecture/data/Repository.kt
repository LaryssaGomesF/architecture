package com.example.architecture.data

import com.example.architecture.utils.Utils

class Repository {

    private var mCounter = 10

    fun getCounter(): String = mCounter.toString()


    fun incrementCounter() {
        mCounter++
    }

    fun decrementCounter() {
        mCounter--
    }

    fun isLoginValid(userName: String, password: String): Boolean {
        return if (userName.isEmpty() || password.isEmpty()) {
            false
        } else {
            password == Utils.PASSWORD && userName == Utils.USERNAME
        }
    }
}
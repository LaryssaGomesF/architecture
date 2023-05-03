package com.example.architecture.presenter

import com.example.architecture.AuthUtils
import com.example.architecture.contracts.LoginContract

class LoginPresenter(private val view : LoginContract.LoginView) : LoginContract.Presenter {


    override fun isLoginValid(userName: String, password: String) {
        if(userName.isEmpty() || password.isEmpty()) {
            view.displayErrorMessage()
        } else {
            if(password == AuthUtils.PASSWORD && userName == AuthUtils.USERNAME) {
                view.displaySucessToast()
                view.startHomeActivity()
            }else {
                view.displayErrorMessage()
            }
        }
    }

}
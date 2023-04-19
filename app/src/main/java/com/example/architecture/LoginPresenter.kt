package com.example.architecture

class LoginPresenter(private val view : LoginContract.View) : LoginContract.Presenter {


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

    override fun start() {

    }
}
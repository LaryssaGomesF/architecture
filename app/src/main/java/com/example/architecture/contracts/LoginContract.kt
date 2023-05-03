package com.example.architecture.contracts

import com.example.architecture.presenter.LoginPresenter
import com.example.architecture.mvp.BaseView

interface LoginContract {

    /**
     * Nossa LoginActivity precisa implementar os métodos definidos abaixo
     */
    interface LoginView : BaseView<LoginPresenter> {
        fun displayErrorMessage()
        fun displaySucessToast()
        fun startHomeActivity()
    }

    /**
     * Nosso Presenter precisa implementar os seguintes métodos
     */
    interface Presenter {
        fun isLoginValid(userName: String, password : String)
    }
}
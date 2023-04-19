package com.example.architecture

import com.example.architecture.mvp.BasePresenter
import com.example.architecture.mvp.BaseView

interface LoginContract {

    /**
     * Nossa LoginActivity precisa implementar os métodos definidos abaixo
     */
    interface View : BaseView<LoginPresenter> {
        fun displayErrorMessage()
        fun displaySucessToast()
        fun startHomeActivity()
    }

    /**
     * Nosso Presenter precisa implementar os seguintes métodos
     */
    interface Presenter : BasePresenter {
        fun isLoginValid(userName: String, password : String)
    }
}
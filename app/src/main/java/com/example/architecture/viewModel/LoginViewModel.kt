package com.example.architecture.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.architecture.data.Repository

class LoginViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _loginResult: MutableLiveData<Boolean> = MutableLiveData()
    val loginResult: LiveData<Boolean>
        get() = _loginResult

    fun doLogin(email: String, password: String) {
        _loginResult.postValue(repository.isLoginValid(email, password))
    }
}
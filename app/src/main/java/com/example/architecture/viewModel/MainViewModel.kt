package com.example.architecture.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.architecture.data.Repository

class MainViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _counter: MutableLiveData<String> = MutableLiveData()
    val counter: LiveData<String>
        get() = _counter


    fun incrementValue() {
        repository.incrementCounter()
        _counter.postValue(repository.getCounter())
    }

    fun decrementValue() {
        repository.decrementCounter()
        _counter.postValue(repository.getCounter())
    }

    fun getCount() {
        _counter.postValue(repository.getCounter())
    }
}
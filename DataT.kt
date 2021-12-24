package com.example.harajtask

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DataT constructor(private val context: Context): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(DataViewModel::class.java)) {
            DataViewModel(context) as T
        } else {
            throw IllegalArgumentException("Err !")
        }
    }
}

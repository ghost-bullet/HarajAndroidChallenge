package com.example.harajtask

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.*
import com.google.gson.reflect.TypeToken
import java.io.InputStream

class DataViewModel() : ViewModel() {
    private lateinit var mutable:MutableLiveData<List<DataHaraj>>
    constructor(context: Context) : this(){
        mutable = MutableLiveData()
        val json : String
        val inputStream: InputStream = context.assets.open("data.json")
        val size : Int = inputStream.available()
        val byteArray = ByteArray(size)
        inputStream.read(byteArray)
        inputStream.close()
        json = String(byteArray,Charsets.UTF_8)
        val gson = GsonBuilder().create()
        val mList = gson.fromJson<List<DataHaraj>>(json, object: TypeToken<List<DataHaraj>>(){}.type)
        mutable.value = mList
    }

    fun getMutable() : MutableLiveData<List<DataHaraj>>{
        return mutable
    }

}

data class DataResponse(val list:List<DataHaraj>)
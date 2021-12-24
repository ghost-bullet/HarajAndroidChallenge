package com.example.harajtask

import java.io.Serializable

class DataHaraj (val title:String,
                 val thumbURL:String,
                 val username:String,
                 val commentCount:Int,
                 val city:String,
                 val date:Int,
                 val body:String) : Serializable
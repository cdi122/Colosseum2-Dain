package com.example.colosseum2_dain

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){

    val mContext = this
    abstract fun setupEvents()
    abstract fun setValues()

}
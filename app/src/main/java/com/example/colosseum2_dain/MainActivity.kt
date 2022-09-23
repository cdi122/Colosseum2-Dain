package com.example.colosseum2_dain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.colosseum2_dain.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        loginBtn.setOnClickListener {

            val inputEmail = emailEdt.text.toString()
            val inputPw = passwordEdt.text.toString()
            ServerUtil.postRequestLogin(inputEmail, inputPw, object : ServerUtil.Companion.JsonReponseHandler {
                override fun onResponse(jsonObj: JSONObject) {

                }

            })


        }
    }

    override fun setValues() {

    }


}
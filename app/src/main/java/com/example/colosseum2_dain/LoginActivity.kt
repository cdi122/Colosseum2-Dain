package com.example.colosseum2_dain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.colosseum2_dain.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        signUpBtn.setOnClickListener {
            val myIntent = Intent(mContext, SignUpActivity::class.java)
            startActivity(myIntent)
        }
        loginBtn.setOnClickListener {

            val inputEmail = emailEdt.text.toString()
            val inputPw = passwordEdt.text.toString()

            ServerUtil.postRequestLogin(inputEmail, inputPw, object : ServerUtil.Companion.JsonResponseHandler {
                override fun onResponse(jsonObj: JSONObject) {

                    val code = jsonObj.getInt("code")
                    if (code == 200) {}
                    else { val message = jsonObj.getString("message")
                        runOnUiThread {Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
                        }

                }

            }


        })
    }



    }

    override fun setValues() {}
}
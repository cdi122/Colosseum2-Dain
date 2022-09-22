package com.example.colosseum2_dain.utils

import android.util.Log
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import kotlin.math.log

class ServerUtil {

    companion object {

    val BASE_URL = "http://54.180.52.26"

    fun postRequestLogin(email : String, pw : String) {


        val urlString = "${BASE_URL}/user"

        val formData = FormBody.Builder()
            .add("email", email)
            .add("password", pw)
            .build()


        val request = Request.Builder()
            .url(urlString)
            .post(formData)
            .build()

        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                val bodyString = response.body!!.string()
                val jsonObj = JSONObject(bodyString)
                Log.d("응답본문", jsonObj.toString())
            }

        })

    }
}
}
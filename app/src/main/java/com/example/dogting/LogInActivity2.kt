package com.example.dogting

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dogting.databinding.ActivityLogIn2Binding

class LogInActivity2 : AppCompatActivity() {
    companion object {
        const val PREFS_NAME = "myPrefs"
        const val PREF_USERNAME = "username"
        const val PREF_PASSWORD = "password"
    }

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivityLogIn2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            val savedUsername = sharedPreferences.getString(PREF_USERNAME, null)
            val savedPassword = sharedPreferences.getString(PREF_PASSWORD, null)

            if (binding.etId.text.toString() == savedUsername && binding.etPassword.text.toString() == savedPassword) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "아이디 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnRegister.setOnClickListener {  //회원가입 창으로 이동하기
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
package com.demo.thotot.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.thotot.R
import kotlinx.android.synthetic.main.activity_phone_login.*

class PhoneLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_login)

        btn_to_main.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        btn_back.setOnClickListener {
            onBackPressed()
        }

    }
}
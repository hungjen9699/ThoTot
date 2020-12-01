package com.demo.thotot.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.thotot.R
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        btn_back.setOnClickListener { onBackPressed() }
    }
}
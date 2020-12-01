package com.demo.thotot.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.thotot.R
import kotlinx.android.synthetic.main.activity_employee_selector.*

class EmployeeSelectorActivity : AppCompatActivity() {

    companion object{
        var selected = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_selector)

        btn_back.setOnClickListener { onBackPressed() }

        btn_select.setOnClickListener {
            selected = true
            onBackPressed()
        }

    }

}
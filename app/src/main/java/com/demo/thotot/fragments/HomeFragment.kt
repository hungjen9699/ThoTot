package com.demo.thotot.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.demo.thotot.R
import com.demo.thotot.activities.AirConditionActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_air_conditioner.setOnClickListener {
            startActivity(Intent(context!!, AirConditionActivity::class.java))
        }
    }

}
package com.demo.thotot.activities

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.demo.thotot.R
import com.demo.thotot.fragments.SuccessDialogFragment
import kotlinx.android.synthetic.main.activity_air_condition.*

class AirConditionActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_air_condition)

        setupAll()
    }

    private fun setupAll(){
        btn_back.setOnClickListener { onBackPressed() }

        btn_choose_location.setOnClickListener {
            startActivity(Intent(this, MapActivity::class.java))
        }

        switch_find.setOnCheckedChangeListener { _ , isChecked ->

            if(!isChecked){
                slide_container.animate()
                    .translationY(0f)
                    .alpha(0.0f)
                    .setListener(object: AnimatorListenerAdapter(){
                        override fun onAnimationEnd(animation: Animator?) { slide_container.visibility = View.GONE }
                    })
            }else{
                slide_container.animate()
                    .translationY(0f)
                    .alpha(1.0f)
                    .setListener(object: AnimatorListenerAdapter(){
                        override fun onAnimationEnd(animation: Animator?) { slide_container.visibility = View.VISIBLE }
                    })
            }

        }

        btn_confirm.setOnClickListener {
            val successDialog = SuccessDialogFragment()
            successDialog.show(supportFragmentManager, "Success Dialog")
        }
    }

}
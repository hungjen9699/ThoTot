package com.demo.thotot.fragments

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.demo.thotot.R
import com.demo.thotot.activities.AirConditionActivity
import com.demo.thotot.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_success_dialog.*


class SuccessDialogFragment(): DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dialog?.window?.setBackgroundDrawable(ContextCompat.getDrawable(context!!, R.drawable.bg_rounded_corners_rectangle))
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_success_dialog, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fadeout = AlphaAnimation(1f, 1f)
        fadeout.duration = 2000

        fadeout.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationRepeat(animation: Animation?) = Unit

            override fun onAnimationStart(animation: Animation?){
                gif_success.setBackgroundResource(R.drawable.img_success)
            }

            override fun onAnimationEnd(animation: Animation?){
                val intent = Intent(context!!, MainActivity::class.java)
                intent.putExtra("uploaded", true)
                startActivity(intent)
            }

        })

        gif_success.startAnimation(fadeout)

    }

}
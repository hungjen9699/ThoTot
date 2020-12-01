package com.demo.thotot.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.demo.thotot.R
import com.demo.thotot.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_activity.*

class ActivityFragment : Fragment() {

    private lateinit var mChildFragmentManager: FragmentManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mChildFragmentManager = childFragmentManager
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        RequestedFragment().setup(R.id.container_frame)
        setupAll()
    }

    private fun setupAll(){

        if(arguments != null && arguments?.getString(MainActivity.STR_BUNDLE) != null){
            btn_accepted.setCheckedAnimation()

            btn_requested.setUnCheckedAnimation()
            btn_history.setUnCheckedAnimation()

            AcceptedFragment().setup(R.id.container_frame)
        }

        btn_requested.setOnClickListener {
            btn_requested.setCheckedAnimation()

            btn_accepted.setUnCheckedAnimation()
            btn_history.setUnCheckedAnimation()

            RequestedFragment().setup(R.id.container_frame)
        }

        btn_accepted.setOnClickListener {
            btn_accepted.setCheckedAnimation()

            btn_requested.setUnCheckedAnimation()
            btn_history.setUnCheckedAnimation()

            AcceptedFragment().setup(R.id.container_frame)
        }

        btn_history.setOnClickListener {
            btn_history.setCheckedAnimation()

            btn_accepted.setUnCheckedAnimation()
            btn_requested.setUnCheckedAnimation()

            HistoryFragment().setup(R.id.container_frame)
        }

    }

    private fun Button.setCheckedAnimation(){
        background = ContextCompat.getDrawable(context!!, R.drawable.bg_general_rounded_corners_rectangle)
        setTextColor(ContextCompat.getColor(context!!, R.color.colorWhite))
    }

    private fun Button.setUnCheckedAnimation(){
        background = ContextCompat.getDrawable(context!!, R.drawable.bg_rounded_corners_blue_stroke_rectangle)
        setTextColor(ContextCompat.getColor(context!!, R.color.colorBlack))
    }

    private fun Fragment.setup(id: Int) {

        if(!isAdded){
            mChildFragmentManager
                .beginTransaction()
                .replace(id, this)
                .commit()
        }else{
            childFragmentManager
                .beginTransaction()
                .replace(id, this)
                .commit()
        }

    }

}
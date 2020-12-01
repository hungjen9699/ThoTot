package com.demo.thotot.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.demo.thotot.activities.AirConditionActivity
import com.demo.thotot.fragments.ActivityFragment
import com.demo.thotot.fragments.HomeFragment
import com.demo.thotot.fragments.MailBoxFragment
import com.demo.thotot.fragments.ProfileFragment

class ViewPagerAdapter(
    supportFragment: FragmentManager,
    private val argument: Bundle
) : FragmentStatePagerAdapter(supportFragment, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    override fun getItem(position: Int): Fragment {
        val fragment = newInstance(position)!!
        fragment.arguments = argument
        return fragment
    }

    private fun newInstance(i: Int): Fragment?{
        return when(i){
            0 -> HomeFragment()
            1 -> ActivityFragment()
            2 -> MailBoxFragment()
            else -> ProfileFragment() //i = 3
        }
    }

    override fun getCount() = 4

}
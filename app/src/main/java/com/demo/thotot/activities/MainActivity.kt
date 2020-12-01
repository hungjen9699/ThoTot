package com.demo.thotot.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.demo.thotot.R
import com.demo.thotot.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {

    private val mBundle = Bundle()

    companion object{
        val STR_BUNDLE = "fromEmployeeSelectorActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupAll()
    }

    override fun onResume() {
        super.onResume()

        if (intent?.extras?.getBoolean("uploaded") != null){
            view_container.currentItem = 1
        }

        if(EmployeeSelectorActivity.selected){
            mBundle.putString(STR_BUNDLE, "true")
            //Setup ViewPager
            view_container.adapter = ViewPagerAdapter(supportFragmentManager, mBundle)
            view_container.currentItem = 1
        }

    }

    private fun setupAll(){

        //Setup ViewPager
        view_container.adapter = ViewPagerAdapter(supportFragmentManager, mBundle)

        view_container.currentItem = 0
        bottom_appbar.selectedItemId = R.id.nav_home

        view_container.addOnPageChangeListener(this)


        //Setup Bottom Menu Fragments
        bottom_appbar.setOnNavigationItemSelectedListener {
            view_container.currentItem = when(it.itemId){
                R.id.nav_home -> 0
                R.id.nav_activity -> 1
                R.id.nav_mailbox -> 2
                else -> 3 // R.id.nav_profile
            }
            return@setOnNavigationItemSelectedListener true
        }

    }


    override fun onPageSelected(position: Int) {
        bottom_appbar.selectedItemId = when(position){
            0 -> R.id.nav_home
            1 -> R.id.nav_activity
            2 -> R.id.nav_mailbox
            else -> R.id.nav_profile // itemIndex = 2
        }
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) = Unit
    override fun onPageScrollStateChanged(state: Int) = Unit

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
        exitProcess(0)
    }

}
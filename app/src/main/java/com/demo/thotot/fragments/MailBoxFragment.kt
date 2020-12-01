package com.demo.thotot.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.thotot.R
import com.demo.thotot.adapters.MailBoxAdapter
import kotlinx.android.synthetic.main.fragment_mail_box.*

class MailBoxFragment : Fragment() {

    private val mMails = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mail_box, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createSampleData() //Demo only

        recycler_mailbox.apply {
            layoutManager = LinearLayoutManager(context!!, RecyclerView.VERTICAL, false)
            adapter = MailBoxAdapter(context!!, mMails)
        }
    }

    private fun createSampleData(){
        mMails.add("")
        mMails.add("")
        mMails.add("")
        mMails.add("")
        mMails.add("")
    }

}
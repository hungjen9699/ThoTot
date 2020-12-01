package com.demo.thotot.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.demo.thotot.R
import com.demo.thotot.activities.NotificationActivity
import kotlinx.android.synthetic.main.layout_mail_item.view.*

class MailBoxAdapter(
    private val mContext: Context,
    private val mMails: List<String>
): RecyclerView.Adapter<MailBoxAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(mContext).inflate(
                R.layout.layout_mail_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = mMails.size

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        holder.containerMailItem.setOnClickListener {
            mContext.startActivity(Intent(mContext, NotificationActivity::class.java))
        }
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val containerMailItem = itemView.container_mail_item!!
    }
}
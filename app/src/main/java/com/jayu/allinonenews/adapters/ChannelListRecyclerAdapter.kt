package com.jayu.allinonenews.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.jayu.allinonenews.R
import com.jayu.allinonenews.fragments.ChannelSubListFragment
import com.jayu.allinonenews.models.Channel

class ChannelListRecyclerAdapter(val context: Context, val channelList:ArrayList<Channel>) : RecyclerView.Adapter<ChannelListRecyclerAdapter.viewHolder>(){
    class viewHolder(view : View) : RecyclerView.ViewHolder(view){
        val channelId : TextView = view.findViewById(R.id.channelId)
        val channelName : TextView = view.findViewById(R.id.channelName)
        val channelImage : ImageView = view.findViewById(R.id.channelImage)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_channel_list_single_row,parent,false)

        return viewHolder(view)
    }

    override fun onBindViewHolder(holder:viewHolder, position: Int) {
        val number = channelList[position]
        holder.channelId.text = number.channelId.toString()
        holder.channelName.text = number.channelName
        holder.channelImage.setImageResource(number.newsImage)

        holder.itemView.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("id",number.channelId.toString())
            bundle.putString("name",number.channelName)
            val myFragment = ChannelSubListFragment()
            myFragment.arguments = bundle
            (it.context as AppCompatActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment,myFragment)
                .addToBackStack(null)
                .commit()

        }
    }

    override fun getItemCount(): Int {
        return channelList.size
    }

}
package com.jayu.allinonenews.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.jayu.allinonenews.R
import com.jayu.allinonenews.adapters.ChannelSubListRecyclerAdapter
import com.jayu.allinonenews.utils.Arrays
import com.jayu.allinonenews.utils.toast

class ChannelSubListFragment : Fragment() {

    private lateinit var parentId : String
    private lateinit var name : String
    private lateinit var toolbar : Toolbar
    private lateinit var channelSubListRecyclerView : RecyclerView
    private lateinit var channelSubListLayoutManager : RecyclerView.LayoutManager
    private lateinit var channelSubListRecyclerAdapter : ChannelSubListRecyclerAdapter

    private val array = Arrays()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater
            .inflate(
                R.layout.fragment_channel_sub_list,
                container,
                false
            )
        val bundle= arguments
        val navView: NavigationView = activity!!.findViewById(R.id.navigationView)

        toolbar = activity!!.findViewById(R.id.toolbar)
        channelSubListRecyclerView = view.findViewById(R.id.channelSubListRecyclerView)
        channelSubListLayoutManager = LinearLayoutManager(context)
        navView.setCheckedItem(R.id.home)

        if (bundle == null){
            context?.toast("Sorry, something went wrong")
            onDestroy()
            return null
        }

        parentId = bundle.getString("id") ?: ""
        name = bundle.getString("name") ?: ""
        toolbar.title = name

        array.channelSubListArray.clear()
        for (i in array.allChannelSubListArray){
            if (i.parentId.toString() == parentId){
                array.channelSubListArray.add(i)
            }
        }

        channelSubListRecyclerAdapter = ChannelSubListRecyclerAdapter(context as Context,array.channelSubListArray)
        channelSubListRecyclerView.adapter = channelSubListRecyclerAdapter
        channelSubListRecyclerView.layoutManager = channelSubListLayoutManager

        return view
    }

    override fun onDestroy() {
        toolbar.title = "Home"
        super.onDestroy()
    }
}
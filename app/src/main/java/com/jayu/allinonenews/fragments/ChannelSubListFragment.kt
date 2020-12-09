package com.jayu.allinonenews.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jayu.allinonenews.R
import com.jayu.allinonenews.adapters.ChannelSubListRecyclerAdapter
import com.jayu.allinonenews.utils.Arrays
import com.jayu.allinonenews.utils.StringConstants
import com.jayu.allinonenews.utils.toast

class ChannelSubListFragment : Fragment() {

    private lateinit var parentId : String
    private lateinit var name : String
    private lateinit var toolbar : Toolbar

    private val constants = StringConstants()
    private val array = Arrays()

    private lateinit var channelSubListRecyclerView : RecyclerView
    private lateinit var channelSubListLayoutManager : RecyclerView.LayoutManager
    private lateinit var channelSubListRecyclerAdapter : ChannelSubListRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_channel_sub_list, container, false)
        val bundle= arguments

        toolbar = activity!!.findViewById(R.id.toolbar)
        channelSubListRecyclerView = view.findViewById(R.id.channelSubListRecyclerView)
        channelSubListLayoutManager = LinearLayoutManager(context)

        if (bundle == null){
            context?.toast("Sorry, something went wrong")
            (view.context as AppCompatActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment,ChannelListFragment())
                .commit()

            return null
        }

        parentId = bundle.getString("id") ?: ""
        name = bundle.getString("name") ?: ""
        toolbar.title = name

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
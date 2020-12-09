package com.jayu.allinonenews.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.*
import com.jayu.allinonenews.R
import com.jayu.allinonenews.fragments.NewsFragment
import com.jayu.allinonenews.models.ChannelSubList
import com.jayu.allinonenews.utils.toast


class ChannelSubListRecyclerAdapter(
    val context: Context,
    val channelSubList: ArrayList<ChannelSubList>
) : RecyclerView.Adapter<ChannelSubListRecyclerAdapter.viewHolder>() {

    private lateinit var mInterstitialAd: InterstitialAd
//    private lateinit var mAdView : AdView

    class viewHolder(view: View, viewType: Int) : RecyclerView.ViewHolder(view){
        val parentId : TextView? = view.findViewById(R.id.channelParentId)
        val id : TextView? = view.findViewById(R.id.channelSubListId)
        val url : TextView? = view.findViewById(R.id.channelUrl)
        val name : TextView? = view.findViewById(R.id.txtChannelSubListName)
        val mAdView : AdView? = view.findViewById(R.id.mainAds)
    }

    override fun getItemViewType(position: Int): Int {
        return if (position %5 ==0){
            0
        }
        else{
            1
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): viewHolder {

        val view : View

        if (viewType == 0){

            view = LayoutInflater.from(parent.context).inflate(
                R.layout.ads,
                parent,
                false
            )
        }

        else{
            view = LayoutInflater.from(parent.context).inflate(
                R.layout.item_channel_sub_list_single_row,
                parent,
                false
            )
        }

        return viewHolder(view,viewType)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        val adView = AdView(context)
        adView.adSize = AdSize.BANNER
        adView.adUnitId = context.getString(R.string.aionBanner)

        MobileAds.initialize(context){}
        holder.mAdView?.loadAd(AdRequest.Builder().build())

        mInterstitialAd = InterstitialAd(context)
        mInterstitialAd.adUnitId = context.getString(R.string.aionInterstital)
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        val number = channelSubList[position]
        holder.parentId?.text = number.parentId.toString()
        holder.id?.text = number.id.toString()
        holder.url?.text = number.url
        holder.name?.text = number.name

        holder.itemView.setOnClickListener{

            if (mInterstitialAd.isLoaded){
                mInterstitialAd.show()
            }

            (it.context as AppCompatActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, NewsFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun getItemCount(): Int {
        return channelSubList.size
    }

}
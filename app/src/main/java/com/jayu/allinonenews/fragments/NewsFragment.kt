package com.jayu.allinonenews.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.jayu.allinonenews.R

class NewsFragment : Fragment() {

    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view =inflater.inflate(R.layout.fragment_news, container, false)

        mInterstitialAd = InterstitialAd(context)
        mInterstitialAd.adUnitId = context?.getString(R.string.aionInterstital)
//        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712" //Testing UnitId for Interstitial ad
        mInterstitialAd.loadAd(AdRequest.Builder().build())


        return view
    }

    override fun onDestroy() {
        mInterstitialAd.show()
        super.onDestroy()
    }
}
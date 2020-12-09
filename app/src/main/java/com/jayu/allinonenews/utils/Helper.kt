package com.jayu.allinonenews.utils

import android.content.Context
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.jayu.allinonenews.R

fun Context.toast(message : String) =
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()


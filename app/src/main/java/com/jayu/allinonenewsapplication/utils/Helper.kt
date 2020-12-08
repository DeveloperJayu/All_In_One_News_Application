package com.jayu.allinonenewsapplication.utils

import android.content.Context
import android.widget.Toast

class Helper {

    fun Context.toast(msg : String) = Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
}
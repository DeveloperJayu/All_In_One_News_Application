package com.jayu.allinonenews.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prof.rssparser.Channel
import com.prof.rssparser.Parser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request

class MyViewModel : ViewModel() {

    private val _snackbar = MutableLiveData<String>()
    val snackbar : LiveData<String> get() = _snackbar
    private val _rssChannel = MutableLiveData<Channel>()
    val rssChannel : LiveData<Channel> get() = _rssChannel

    private val okHttpClient by lazy {
        OkHttpClient()
    }

    fun OnSnackbarShowed(){
        _snackbar.value = null
    }

    fun fetchForUrlAndParseRawData(url : String){
        val parser = Parser.Builder().build()

        viewModelScope.launch(Dispatchers.IO) {
            val request = Request.Builder()
                .url(url)
                .build()
            val result = okHttpClient.newCall(request).execute()
            val raw = kotlin.runCatching { result.body()?.string() }.getOrNull()
            if (raw == null){
                _snackbar.value = "Something went wrong"
            }
            else{
                val channel = parser.parse(raw)
                _rssChannel.postValue(channel)
            }
        }
    }
}
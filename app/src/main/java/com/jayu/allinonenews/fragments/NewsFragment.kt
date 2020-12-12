package com.jayu.allinonenews.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.material.snackbar.Snackbar
import com.jayu.allinonenews.R
import com.jayu.allinonenews.adapters.NewsRecyclerAdapter
import com.jayu.allinonenews.models.News
import com.jayu.allinonenews.utils.Arrays
import com.jayu.allinonenews.utils.MyViewModel
import com.jayu.allinonenews.utils.toast
import com.prof.rssparser.Parser
import java.nio.charset.Charset

class NewsFragment : Fragment() {

    private lateinit var mInterstitialAd: InterstitialAd
    private lateinit var parser : Parser
    private lateinit var name : String
    private lateinit var url : String
    private lateinit var toolbar: Toolbar
    private lateinit var newsRecyclerView : RecyclerView
    private lateinit var newsLayoutManager : RecyclerView.LayoutManager
    private lateinit var newsRecyclerAdapter : NewsRecyclerAdapter

    private val viewModel = MyViewModel()
    private val array = Arrays()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_news, container, false)

        newsRecyclerView = view.findViewById(R.id.newsRecyclerView)
        newsLayoutManager = LinearLayoutManager(context)
        newsRecyclerAdapter = NewsRecyclerAdapter(context as Context,array.newsArray)
        newsRecyclerView.layoutManager = newsLayoutManager
        newsRecyclerView.adapter = newsRecyclerAdapter
        toolbar = activity!!.findViewById(R.id.toolbar)

        val bundle = arguments
        if (bundle == null){
            context?.toast("Something went wrong")
            onDestroy()
            return null
        }

        name = bundle.getString("name") ?: ""
        url = bundle.getString("url") ?: ""
        toolbar.title = name

        parser = Parser.Builder()
            .context(context as Context)
            .charset(Charset.forName("ISO-8859-7"))
            .cacheExpirationMillis(24L*60L*60L*100L)
            .build()

        mInterstitialAd = InterstitialAd(context)
        mInterstitialAd.adUnitId = context?.getString(R.string.aionInterstital)
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        viewModel.rssChannel.observe(this,{channel ->
            if (channel != null){
                val articles = channel.articles
                if (channel.articles.isNotEmpty()){
                    array.newsArray.clear()
                    for (i in 0.. articles.lastIndex){
                        val news = News(
                            articles[i].title ?: "",
                            articles[i].link ?: "",
                            articles[i].image ?: ""
                        )
                        Log.v("title",articles[i].title.toString())
                        Log.v("Url",articles[i].image.toString())
                        array.newsArray.add(news)
                        newsRecyclerAdapter.notifyDataSetChanged()
                    }
                }
                else{
                    context?.toast("Oieeeeeee")
                }
            }
        })

        Log.v("Articles",array.newsArray.toString())

        viewModel.snackbar.observe(this, {value->
            value?.let{
                Snackbar.make(view,value,Snackbar.LENGTH_LONG).show()
                viewModel.OnSnackbarShowed()
            }
        })
        viewModel.fetchForUrlAndParseRawData(url)

        return view
    }

    override fun onDestroy() {
        mInterstitialAd.show()
        super.onDestroy()
    }
}
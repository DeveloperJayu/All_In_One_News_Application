package com.jayu.allinonenews.utils

import com.jayu.allinonenews.R
import com.jayu.allinonenews.models.Channel
import com.jayu.allinonenews.models.ChannelSubList

class Arrays {
    val constants = Constants()
    val url = URLConstants()

    var channelListArray= arrayListOf<Channel>(
        Channel(1,constants.gs, R.drawable.gujaratsamachar),
        Channel(2,constants.db, R.drawable.divyabhaskar)
    )

    var allChannelSubListArray = arrayListOf<ChannelSubList>(
        ChannelSubList(1,1,constants.topStories,url.gsTopStoriesUrl),
        ChannelSubList(1,2,constants.scienceAndTechnology,url.gsScienceAndTechnologyUrl),
        ChannelSubList(1,3,constants.relationship,url.gsRelationshipUrl),
        ChannelSubList(1,4,constants.lifestyleAndFashion,url.gsLifestyleAndFashionUrl),
        ChannelSubList(1,5,constants.health,url.gsHealthUrl),
        ChannelSubList(1,6,constants.astro,url.gsAstroUrl),
        ChannelSubList(1,7,constants.nriNews,url.gsNriNewsUrl),
        ChannelSubList(1,8,constants.entertainment,url.gsEntertainmentUrl),
        ChannelSubList(1,9,constants.sports,url.gsSportsUrl),
        ChannelSubList(1,10,constants.business,url.gsBusinessUrl),
        ChannelSubList(1,11,constants.international,url.gsIinternationalUrl),
        ChannelSubList(1,12,constants.national,url.gsNationalUrl),
        ChannelSubList(1,13,constants.gujarat,url.gsGujaratUrl),
        ChannelSubList(1,14,constants.uttarGujarat,url.gsUttarGujaratUrl),
        ChannelSubList(1,15,constants.madhyaGujarat,url.gsMadhyaGujaratUrl),
        ChannelSubList(1,16,constants.saurashtra,url.gsSaurashtraUrl),
        ChannelSubList(1,17,constants.kutch,url.gsKutchUrl),
        ChannelSubList(1,18,constants.daxinGujarat,url.gsDaxinGujaratUrl),
        ChannelSubList(1,19,constants.ahmedabad,url.gsAhmedabadUrl),
        ChannelSubList(1,20,constants.baroda,url.gsBarodaUrl),
        ChannelSubList(1,21,constants.surat,url.gsSuratUrl),
        ChannelSubList(1,22,constants.rajkot,url.gsRajkotUrl),
        ChannelSubList(1,23,constants.bhavnagar,url.gsBhavnagarUrl),
        ChannelSubList(1,24,constants.bhuj,url.gsBhujUrl),
        ChannelSubList(1,25,constants.kheda,url.gsKhedaUrl),
        ChannelSubList(1,26,constants.gandhinagar,url.gsGandhinagarUrl),
        ChannelSubList(1,27,constants.northGujarat,url.gsNorthGujaratUrl),
        ChannelSubList(2,1,constants.entertainment,url.dbEntertainmentUrl),
        ChannelSubList(2,2,constants.business,url.dbBusinessUrl),
        ChannelSubList(2,3,constants.national,url.dbNationalUrl),
        ChannelSubList(2,4,constants.international,url.dbInternationalUrl),
        ChannelSubList(2,5,constants.sports,url.dbSportsUrl),
        ChannelSubList(2,6,constants.nrg,url.dbNRGUrl)

    )

    var channelSubListArray = arrayListOf<ChannelSubList>()
}
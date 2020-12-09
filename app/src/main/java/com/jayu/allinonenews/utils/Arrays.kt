package com.jayu.allinonenews.utils

import com.jayu.allinonenews.R
import com.jayu.allinonenews.models.Channel
import com.jayu.allinonenews.models.ChannelSubList

class Arrays {
    val constants = StringConstants()
    val url = URLConstants()

    var channelListArray= arrayListOf<Channel>(
        Channel(1,constants.gs, R.drawable.gujaratsamachar),
        Channel(2,constants.db, R.drawable.divyabhaskar),
        Channel(3,constants.asmita,R.drawable.abpasmita)
    )

    var allChannelSubListArray = arrayListOf<ChannelSubList>(

        //Gujarat Samachar
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

        //Divya Bhaskar
        ChannelSubList(2,1,constants.entertainment,url.dbEntertainmentUrl),
        ChannelSubList(2,2,constants.business,url.dbBusinessUrl),
        ChannelSubList(2,3,constants.national,url.dbNationalUrl),
        ChannelSubList(2,4,constants.international,url.dbInternationalUrl),
        ChannelSubList(2,5,constants.sports,url.dbSportsUrl),
        ChannelSubList(2,6,constants.nrg,url.dbNRGUrl),

        //Asmita
        ChannelSubList(3,1,constants.home,url.asHomeUrl),
        ChannelSubList(3,2,constants.gujarat,url.asGujaratUrl),
        ChannelSubList(3,3,constants.business,url.asBusinessUrl),
        ChannelSubList(3,4,constants.national,url.asNationalUrl),
        ChannelSubList(3,5,constants.sports,url.asSportsUrl),
        ChannelSubList(3,6,constants.ahmedabad,url.asAhmedabadUrl),
        ChannelSubList(3,7,constants.surat,url.asSuratUrl),
        ChannelSubList(3,8,constants.vadodara,url.asVadodaraUrl),
        ChannelSubList(3,9,constants.rajkot,url.asRajkotUrl),
        ChannelSubList(3,10,constants.gandhinagar,url.asGandhinagarUrl),
        ChannelSubList(3,11,constants.mehsana,url.asMehsanaUrl),
        ChannelSubList(3,12,constants.anand,url.asAnandUrl),
        ChannelSubList(3,12,constants.asmitaVishesh,url.asViseshUrl),
        ChannelSubList(3,13,constants.world,url.asWorldUrl),
        ChannelSubList(3,14,constants.gadgets,url.asGadgetsUrl),
        ChannelSubList(3,15,constants.lifestyle,url.asLifestyleUrl),
        ChannelSubList(3,16,constants.crime,url.asCrimeUrl),
        ChannelSubList(3,17,constants.dharma,url.asDharmaUrl),
        ChannelSubList(3,18,constants.bollywood,url.asBollywoodUrl),
        ChannelSubList(3,19,constants.viral,url.asViralUrl),
        ChannelSubList(3,20,constants.events,url.asEventsUrl),
        ChannelSubList(3,21,constants.covid19,url.asCovid19)
    )

    var channelSubListArray = arrayListOf<ChannelSubList>()
}
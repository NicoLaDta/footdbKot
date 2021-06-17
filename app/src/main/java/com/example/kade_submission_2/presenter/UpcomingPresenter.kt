package com.example.kade_submission_2.presenter

import com.example.kade_submission_2.api.ApiRepository
import com.example.kade_submission_2.model.MatchResponse
import com.example.kade_submission_2.view.DetailLeagueView
import com.example.kade_submission_2.view.UpcomingMatchView
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.doAsync

class UpcomingPresenter (
    private val view: UpcomingMatchView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {

    fun getUpcomingMatch(idLeague: String?) {
        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(apiRepository
                .doRequest(ApiRepository.TheSportDBApi.getUpcomingMatch(idLeague)).await(),
                MatchResponse::class.java
            )
            if(data.matchResponse != null){
                view.showUpcomingMatch(data.matchResponse)
            }

        }

    }
}


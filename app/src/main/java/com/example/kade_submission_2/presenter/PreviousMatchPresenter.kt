package com.example.kade_submission_2.presenter

import com.example.kade_submission_2.api.ApiRepository
import com.example.kade_submission_2.model.LeagueResponse
import com.example.kade_submission_2.model.MatchResponse
import com.example.kade_submission_2.view.DetailLeagueView
import com.example.kade_submission_2.view.PreviousMatchView
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class PreviousMatchPresenter (
    private val view: PreviousMatchView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {

    fun getPreviousMatch(idLeague: String?) {
        view.showLoading()
        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(apiRepository
                .doRequest(ApiRepository.TheSportDBApi.getPreviousMatch(idLeague)).await(),
                MatchResponse::class.java
            )
                view.hideLoading()
                view.showPreviousMatch(data.matchResponse)

        }

    }
}
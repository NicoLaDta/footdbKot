package com.example.kade_submission_2.presenter

import com.example.kade_submission_2.activity.DetailLigaActivity
import com.example.kade_submission_2.api.ApiRepository
import com.example.kade_submission_2.model.MatchResponse
import com.example.kade_submission_2.view.PreviousMatchView
import com.example.kade_submission_2.view.SearchMatchView
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class SearchMatchPresenter (
    private val view: SearchMatchView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun getSearchMatch(teamsName: String?) {
        view.showLoading()

        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(apiRepository
                .doRequest(ApiRepository.TheSportDBApi.getSearchMatch(teamsName)).await(),
                MatchResponse::class.java
            )

                view.hideLoading()
                view.getMatch(data.searchMatchResponse.filter { it.strSport.equals("Soccer")})

        }

    }
}
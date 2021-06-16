package com.example.kade_submission_2.presenter

import com.example.kade_submission_2.activity.DetailTeamActivity
import com.example.kade_submission_2.api.ApiRepository
import com.example.kade_submission_2.model.MatchResponse
import com.example.kade_submission_2.model.SearchTeamResponse
import com.example.kade_submission_2.model.TeamsResponse
import com.example.kade_submission_2.view.SearchMatchView
import com.example.kade_submission_2.view.SearchTeamView
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SearchTeamPresenter (
    private val view: SearchTeamView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {

    fun getSearchTeam(teamName: String?) {
        view.showLoading()

        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(apiRepository
                .doRequest(ApiRepository.TheSportDBApi.getSearchTeam(teamName)).await(),
                SearchTeamResponse::class.java
            )

            view.hideLoading()
            view.getSearchTeam(data.searchTeamResponse)

        }
    }
}
package com.example.kade_submission_2.presenter

import com.example.kade_submission_2.api.ApiRepository
import com.example.kade_submission_2.model.DetailTeamResponse
import com.example.kade_submission_2.model.TeamsResponse
import com.example.kade_submission_2.view.DetailTeamView
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailTeamPresenter(
    private val view: DetailTeamView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {

    fun getTeamDetail(idTeam: String?) {

        GlobalScope.launch (Dispatchers.Main) {

            val data = gson.fromJson(apiRepository
                .doRequest(ApiRepository.TheSportDBApi.getTeamDetails(idTeam)).await(),
                DetailTeamResponse::class.java)

            view.showTeamDetail(data.detailTeamsResponse)
        }
    }
}

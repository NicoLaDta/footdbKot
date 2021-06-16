package com.example.kade_submission_2.presenter

import com.example.kade_submission_2.api.ApiRepository
import com.example.kade_submission_2.model.TeamsResponse
import com.example.kade_submission_2.view.ListTeamView
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class TeamListPresenter (
    private val view: ListTeamView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {

    fun getListTeam(idLeague: String?) {

        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(apiRepository
                .doRequest(ApiRepository.TheSportDBApi.getTeamList(idLeague)).await(),
                TeamsResponse::class.java)

            view.showListTeam(data.teamsResponse)
        }
    }
}
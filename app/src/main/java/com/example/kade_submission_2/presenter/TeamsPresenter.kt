package com.example.kade_submission_2.presenter

import com.example.kade_submission_2.api.ApiRepository
import com.example.kade_submission_2.model.MatchResponse
import com.example.kade_submission_2.model.TeamsResponse
import com.example.kade_submission_2.view.*
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamsPresenter (
    private val view: TeamsView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {

    fun getTeams(idHomeTeam: String?, idAwayTeam: String?) {

        GlobalScope.launch(Dispatchers.Main) {
            val homeTeams = gson.fromJson(apiRepository
                .doRequest(ApiRepository.TheSportDBApi.getTeamDetails(idHomeTeam)).await(),
                TeamsResponse::class.java
            )

            val awayTeams = gson.fromJson(apiRepository
                .doRequest(ApiRepository.TheSportDBApi.getTeamDetails(idAwayTeam)).await(),
                TeamsResponse::class.java
            )

                view.showTeams(homeTeams.teamsResponse, awayTeams.teamsResponse)

        }

    }
}



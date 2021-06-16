package com.example.kade_submission_2.presenter

import com.example.kade_submission_2.api.ApiRepository
import com.example.kade_submission_2.model.DetailMatchRespose
import com.example.kade_submission_2.view.DetailMatchView
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class DetailMatchPresenter (
    private val view: DetailMatchView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {

    fun getDetailMatch(idEvents: String?) {
        view.showLoading()
        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(apiRepository
                .doRequest(ApiRepository.TheSportDBApi.getMatchDetails(idEvents)).await(),
                DetailMatchRespose::class.java
            )

            view.hideLoading()
            view.showDetailMatch(data.detailMatchResponse)
        }

    }
}
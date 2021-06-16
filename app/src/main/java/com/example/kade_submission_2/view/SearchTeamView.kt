package com.example.kade_submission_2.view

import com.example.kade_submission_2.model.Teams

interface SearchTeamView {
    fun showLoading()
    fun hideLoading()
    fun getSearchTeam(data: List<Teams>)
}
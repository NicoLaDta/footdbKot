package com.example.kade_submission_2.view

import com.example.kade_submission_2.model.Match

interface SearchMatchView {
    fun showLoading()
    fun hideLoading()
    fun getMatch(data: List<Match>)
}
package com.example.kade_submission_2.view

import com.example.kade_submission_2.model.Match

interface PreviousMatchView {
    fun showLoading()
    fun hideLoading()
    fun showPreviousMatch(data: List<Match>)
}
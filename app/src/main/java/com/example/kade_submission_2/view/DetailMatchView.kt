package com.example.kade_submission_2.view

import com.example.kade_submission_2.model.DetailMatch

interface DetailMatchView {
    fun showLoading()
    fun hideLoading()
    fun showDetailMatch(data: List<DetailMatch?>?)
}
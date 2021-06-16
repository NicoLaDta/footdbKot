package com.example.kade_submission_2.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.kade_submission_2.fragment.PreviousMatchFragment
import com.example.kade_submission_2.fragment.StandingsFragment
import com.example.kade_submission_2.fragment.TeamsFragment
import com.example.kade_submission_2.fragment.UpcomingMatchFragment

class PagerAdapter (fm: FragmentManager): FragmentPagerAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                PreviousMatchFragment()
            }
            1 -> {
                UpcomingMatchFragment()
            }
            2 -> {
                StandingsFragment()
            }
            else ->  {
                return TeamsFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Last Match"
            1 -> "Next Match"
            2 -> "Standing"
            else -> {
                return "Teams"
            }
        }
    }

}
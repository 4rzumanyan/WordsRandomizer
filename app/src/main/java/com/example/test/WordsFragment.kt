package com.example.test

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class WordsFragment : Fragment(R.layout.fragment_words) {
    private val safeArgs: WordsFragmentArgs by navArgs()
    private val wordsAdapter: WordsAdapter by lazy { WordsAdapter() }
    private lateinit var swipeRefresh: SwipeRefreshLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        val wordsRv = view!!.findViewById<RecyclerView>(R.id.words_rv)
        swipeRefresh = view!!.findViewById(R.id.swipe_refresh)

        wordsRv.apply {
            wordsAdapter.submitList(
                getRandomListWithSpecifiedSize(
                    safeArgs.wordsCount,
                    resources.getStringArray(R.array.words_array).toList()
                )
            )
            adapter = wordsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        swipeRefresh.setOnRefreshListener {
            updateWordsList()
        }
    }

    private fun getRandomListWithSpecifiedSize(size: Int, list: List<String>): List<String> {
        val randomList = ArrayList<String>()
        for (i in 1..size) {
            randomList.add(list[(0..list.size).random()])
        }
        return randomList
    }

    private fun updateWordsList() {
        wordsAdapter.submitList(
            getRandomListWithSpecifiedSize(
                safeArgs.wordsCount,
                resources.getStringArray(R.array.words_array).toList()
            )
        )
        swipeRefresh.isRefreshing = false
    }

}
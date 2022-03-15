package com.example.test

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WordsGroupsFragment: Fragment(R.layout.fragment_words_groups) {
    private val safeArgs: WordsGroupsFragmentArgs by navArgs()
    private val wordsGroupAdapter: WordsGroupAdapter by lazy {
        WordsGroupAdapter(safeArgs.groupCount, ::onGroupItemClick)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        val recyclerView: RecyclerView = view!!.findViewById(R.id.words_group_rv)
        recyclerView.apply {
            adapter = wordsGroupAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun onGroupItemClick() {
        findNavController().navigate(WordsGroupsFragmentDirections.actionWordsGroupsFragmentToWordsFragment(safeArgs.wordsCount))
    }
}
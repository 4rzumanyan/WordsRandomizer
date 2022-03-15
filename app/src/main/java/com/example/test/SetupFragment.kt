package com.example.test

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SetupFragment : Fragment(R.layout.fragment_setup) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        val nextButton = view!!.findViewById<Button>(R.id.next_button)
        val groupCountEt = view!!.findViewById<AppCompatEditText>(R.id.group_count_et)
        val wordCountEt = view!!.findViewById<AppCompatEditText>(R.id.words_count_et)

        nextButton.setOnClickListener {
            val groupCount =
                if (groupCountEt.text.isNullOrEmpty()) 10 else groupCountEt.text.toString().toInt()
            val wordCount =
                if (wordCountEt.text.isNullOrEmpty()) 12 else wordCountEt.text.toString().toInt()
            findNavController().navigate(
                SetupFragmentDirections.actionSetupFragmentToWordsGroupsFragment(
                    groupCount,
                    wordCount
                )
            )
        }
    }
}
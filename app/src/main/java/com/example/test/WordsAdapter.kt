package com.example.test

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class WordsAdapter() :
    RecyclerView.Adapter<WordsAdapter.WordsViewHolder>() {
    private var wordsList = mutableListOf<String>()

    class WordsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordsText: AppCompatTextView = itemView.findViewById(R.id.word_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false)
        return WordsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        holder.wordsText.text = wordsList[position]
    }

    override fun getItemCount() = wordsList.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<String>) {
        wordsList.clear()
        wordsList.addAll(list)
        notifyDataSetChanged()
    }

}
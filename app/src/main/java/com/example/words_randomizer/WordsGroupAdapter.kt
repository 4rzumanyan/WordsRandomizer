package com.example.words_randomizer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class WordsGroupAdapter(private val groupsCount: Int, private val onItemClicked: () -> Unit) :
    RecyclerView.Adapter<WordsGroupAdapter.WordsGroupViewHolder>() {

    class WordsGroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val groupText: AppCompatTextView = itemView.findViewById(R.id.group_text)
        val itemContainer: FrameLayout = itemView.findViewById(R.id.group_item_container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsGroupViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_words_group, parent, false)
        return WordsGroupViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordsGroupViewHolder, position: Int) {
        holder.groupText.text = "Group ${position + 1}"
        holder.itemContainer.setOnClickListener { onItemClicked.invoke() }
    }

    override fun getItemCount() = groupsCount

}
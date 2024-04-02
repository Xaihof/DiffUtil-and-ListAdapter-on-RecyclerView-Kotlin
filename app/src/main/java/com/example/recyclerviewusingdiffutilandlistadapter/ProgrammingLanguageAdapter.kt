package com.example.recyclerviewusingdiffutilandlistadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ProgrammingLanguageAdapter :
    ListAdapter<ProgrammingLanguage, ProgrammingLanguageAdapter.ProgrammingLanguageViewHolder>(
        DiffUtilCallBack()
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProgrammingLanguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ProgrammingLanguageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgrammingLanguageViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ProgrammingLanguageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val programmingLanguageInitial =
            view.findViewById<TextView>(R.id.textViewProgrammingLanguageInitial)
        val programmingLanguageName =
            view.findViewById<TextView>(R.id.textViewProgrammingLanguageName)


        fun bind(item: ProgrammingLanguage) {
            programmingLanguageName.text = item.name
            programmingLanguageInitial.text = item.initial
        }
    }

    class DiffUtilCallBack : DiffUtil.ItemCallback<ProgrammingLanguage>() {
        override fun areItemsTheSame(
            oldItem: ProgrammingLanguage,
            newItem: ProgrammingLanguage
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProgrammingLanguage,
            newItem: ProgrammingLanguage
        ): Boolean {

            return oldItem == newItem

        }

    }
}
package com.example.reddit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reddit.data.model.ListModel
import com.example.reddit.R

class AdapterList(private val items: List<ListModel.Data.Children>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       val card =  LayoutInflater.from(parent.context)
           .inflate(R.layout.list_card, parent, false)
        return listViewHolder(card)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = items[position]
        if (holder is listViewHolder){
          holder.listTextView.text = currentItem.data.title
        }
    }

   class listViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
       val listTextView: TextView = itemView.findViewById(R.id.list_textview)
    }

}
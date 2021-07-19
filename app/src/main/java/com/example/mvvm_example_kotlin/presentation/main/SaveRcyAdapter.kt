package com.example.mvvm_example_kotlin.presentation.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_example_kotlin.R
import com.example.mvvm_example_kotlin.data.db.entity.SaveDataEntity

class SaveRcyAdapter(private val _savedList : List<SaveDataEntity>) : RecyclerView.Adapter<SaveRcyAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView.findViewById(R.id.save_item_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.save_rcy_item,parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = _savedList[position].title
    }

    override fun getItemCount(): Int {
        return _savedList.size
    }


}
package com.example.mvvm_example_kotlin.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_example_kotlin.R
import com.example.mvvm_example_kotlin.remote.KakaoSearchResults

class KaKaoRcyAdapter(private val _searchList: List<KakaoSearchResults.Document>) : RecyclerView.Adapter<KaKaoRcyAdapter.ViewHolder>() {

    private var itemOnClickListener : ItemOnClickListener? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView.findViewById(R.id.search_item_title)
    }

    interface ItemOnClickListener{
        fun itemOnClick(v : View, pos : Int)
    }

    fun setItemOnClickListener(_itemOnClickListener: ItemOnClickListener){
        itemOnClickListener = _itemOnClickListener
    }

    fun getList(): List<KakaoSearchResults.Document> {
        return _searchList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.search_rcy_item ,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = _searchList[position].title
        holder.itemView.setOnClickListener {
            if(itemOnClickListener!=null){
                itemOnClickListener!!.itemOnClick(it,position)
            }
        }
    }

    override fun getItemCount(): Int {
        return _searchList.size
    }
}
package com.deepshikhayadav.zomatopremierleague

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.deepshikhayadav.zomatopremierleague.RecyclerAdapter.*
import kotlinx.android.synthetic.main.recycler_item.view.*

class RecyclerAdapter(private val res: List<MyModel>) : RecyclerView.Adapter<MyViewHolder>() {
    class MyViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(myModel: MyModel){
            itemView.teamName.text=myModel.teamName
            itemView.win.text=myModel.win

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        val viewHolder=MyViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) =holder.bind(res[position])

    override fun getItemCount():  Int = res.count()
}
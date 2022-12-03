package com.example.heis.antrian

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.heis.R

class ListAntrianAdapter(private val listAntrian: ArrayList<Antrian>) : RecyclerView.Adapter<ListAntrianAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var tvName :  TextView = itemView.findViewById(R.id.tv_item_antrian)
         var tvNoAntrian : TextView = itemView.findViewById(R.id.tv_item_detail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_antrian, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val antrian = listAntrian[position]

        holder.tvName.text = antrian.nama
        holder.tvNoAntrian.text = antrian.noAntrian
    }

    override fun getItemCount(): Int {
        return listAntrian.size
    }
}
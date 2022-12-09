package com.example.heis.antrian

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.heis.R

class AntrianAdapter() : RecyclerView.Adapter<AntrianAdapter.ListViewHolder>() {

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {

        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    inner class ListViewHolder(itemView: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
         init {
             itemView.setOnClickListener {
                 mListener.onItemClick(adapterPosition)
             }
         }
         var tvName :  TextView = itemView.findViewById(R.id.tv_item_detail)
         var tvNoAntrian : TextView = itemView.findViewById(R.id.tv_item_antrian)
    }

    private val listAntrian = ArrayList<Pasien>()

    fun setItems(list: ArrayList<Pasien>) {
        listAntrian.addAll(list)
    }

    fun clear() { listAntrian.clear() }

    fun getItems() = listAntrian

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_antrian, parent, false)
        return ListViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val antrian = listAntrian[position]

        holder.tvName.text = antrian.nama
        holder.tvNoAntrian.text = antrian.nomorAntrian.toString()
    }

    override fun getItemCount(): Int {
        return listAntrian.size
    }
}
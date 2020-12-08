package com.example.agendatelefonica

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sqliteandroidroom.models.Contato

class ContatosAdapter(): RecyclerView.Adapter<ContatosAdapter.ResultViewHolder>() {
    var listResult = arrayListOf<Contato>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent,false)
        return ResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        var item = listResult[position]
        holder.nomePessoa.text = item.nome
        holder.telefone.text = "Telefone: ${item.nome}"
    }

    override fun getItemCount() = listResult.size

    fun addList(list: List<Contato>){
        listResult.addAll(list)
        notifyDataSetChanged()
    }

    class ResultViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nomePessoa:TextView = view.findViewById(R.id.nomePessoa)
        val telefone:TextView = view.findViewById(R.id.telefone)
    }
}
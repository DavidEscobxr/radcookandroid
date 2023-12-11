package com.example.radcooksplash.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.radcooksplash.Models.Ingredient
import com.example.radcooksplash.R

class IngredientListAdapter(
    var items: ArrayList<Ingredient>,
    private val listener: IngredientItemListener
) : RecyclerView.Adapter<IngredientListAdapter.ViewHolder>() {
    var context: Context? = null

    interface IngredientItemListener {
        fun onDeleteClick(id: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_ingredients, parent, false)
        context = parent.context
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.nameTxt.text = items.get(position).name
        holder.typeTxt.text = items.get(position).type
        holder.btnDelete.setOnClickListener(View.OnClickListener {
            listener.onDeleteClick(
                items[position].id
            )
        })
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTxt: TextView
        var typeTxt: TextView
        var btnDelete: TextView

        init {
            nameTxt = itemView.findViewById(R.id.tvName)
            typeTxt = itemView.findViewById(R.id.tvType)
            btnDelete = itemView.findViewById(R.id.deleteButton)
        }
    }
}
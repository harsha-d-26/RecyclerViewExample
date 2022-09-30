package com.harsh.recyclerexample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter(val context: Context, val contact: List<Person>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.tvName)
        val age = itemView.findViewById<TextView>(R.id.tvAge)

        fun bind(contact: Person){
            name.text = contact.name
            age.text = "Age: ${contact.age}"
        }
    }
    // Expensive Operation
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_person,parent,false)
        view.setOnClickListener {

        }
        return ViewHolder(view)
    }
    // Inexpensive Operation
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cont:Person = contact[position]

        holder.bind(cont)
    }

    override fun getItemCount() = contact.size;

}

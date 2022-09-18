package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val items:List<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>(){
        // Provide a direct reference to each of the views within a data item
        // Used to cache the views within the item layout for fast access
        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val price = itemView.findViewById<TextView>(R.id.PriceItem)
            val itemName = itemView.findViewById<TextView>(R.id.NameItem)
           val  URL = itemView.findViewById<TextView>(R.id.URLItem)

            // We also create a constructor that accepts the entire item row
            // and does the view lookups to find each sub-view

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val context = parent.context
            val inflater = LayoutInflater.from(context)
            // Inflate the custom layout
            val contactView = inflater.inflate(R.layout.list_item, parent, false)
            // Return a new holder instance
            return ViewHolder(contactView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            // Get the data model based on position
            val item = items[position]
            // Set item views based on views and data model
            holder.price.text = item.price_item
            holder.itemName.text = item.name_item
            holder.URL.text = item.URL_item
        }

        override fun getItemCount(): Int {
            return items.size
        }
}
package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(val items: MutableList<WishlistItem>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain a member variable for any view that will be set as you render a row
        val nameTextView: TextView
        val priceTextView: TextView
        val urlTextView: TextView

        //val nameInput = itemView.findViewById<EditText>(R.id.nameEt)

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            nameTextView = itemView.findViewById(R.id.name)
            priceTextView = itemView.findViewById(R.id.price)
            urlTextView = itemView.findViewById(R.id.url)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val item = items.get(position)
        // Set item views based on views and data model
        holder.nameTextView.text = item.name
        holder.priceTextView.text = item.price
        holder.urlTextView.text = item.url
    }
}


//class EmailAdapter(val emails: MutableList<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>(){

//    // Provide a direct reference to each of the views within a data item
//    // Used to cache the views within the item layout for fast access
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        // Your holder should contain a member variable for any view that will be set as you render
//        // a row
//        val senderTextView: TextView
//        val titleTextView: TextView
//        val summaryTextView: TextView
//
//        // We also create a constructor that accepts the entire item row
//        // and does the view lookups to find each sub-view
//        init {
//            // Stores the itemView in a public final member variable that can be used
//            // to access the context from any ViewHolder instance.
//            senderTextView = itemView.findViewById(R.id.senderTv)
//            titleTextView = itemView.findViewById(R.id.titleTv)
//            summaryTextView = itemView.findViewById(R.id.summaryTv)
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val context = parent.context
//        val inflater = LayoutInflater.from(context)
//        // Inflate the custom layout
//        val contactView = inflater.inflate(R.layout.email_item, parent, false)
//        // Return a new holder instance
//        return ViewHolder(contactView)
//    }
//
//    override fun getItemCount(): Int {
//        return emails.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        // Get the data model based on position
//        val email = emails.get(position)
//        // Set item views based on views and data model
//        holder.senderTextView.text = email.sender
//        holder.titleTextView.text = email.title
//        holder.summaryTextView.text = email.summary
//    }
//}
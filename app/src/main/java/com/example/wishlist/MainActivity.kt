package com.example.wishlist

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var items = ArrayList<WishlistItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.button)
        val name = findViewById<EditText>(R.id.nameInput)
        val price = findViewById<EditText>(R.id.priceInput)
        val url = findViewById<EditText>(R.id.urlInput)


        // Lookup the RecyclerView in activity layout
        val wishlistRv = findViewById<RecyclerView>(R.id.wishlistRv)


        button.setOnClickListener{
            //add item to items list
            val newItem = WishlistItem(name.text.toString(), price.text.toString(), url.text.toString())
            items.add(newItem)
            //Log.v("newItem", items[0].name)

            // Create adapter passing in the list of emails
            val adapter = WishlistAdapter(items as MutableList<WishlistItem>)
            // Attach the adapter to the RecyclerView to populate items
            wishlistRv.adapter = adapter
            // Set layout manager to position the items
            wishlistRv.layoutManager = LinearLayoutManager(this)
        }

    }
}


//package com.example.codepathmail
//
//import android.os.Bundle
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//
//
//class MainActivity : AppCompatActivity() {
//    lateinit var emails: List<Email>
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//
//        // Lookup the RecyclerView in activity layout
//        val emailsRv = findViewById<RecyclerView>(R.id.emailsRv)
//        // Fetch the list of emails
//        emails = EmailFetcher.getEmails()
//        // Create adapter passing in the list of emails
//        val adapter = EmailAdapter(emails as MutableList<Email>)
//        // Attach the adapter to the RecyclerView to populate items
//        emailsRv.adapter = adapter
//        // Set layout manager to position the items
//        emailsRv.layoutManager = LinearLayoutManager(this)
//    }
//}
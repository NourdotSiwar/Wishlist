package com.example.wishlist

import android.app.Activity
import android.app.LauncherActivity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wishlist.databinding.ActivityMainBinding
import com.example.wishlist.databinding.ListItemBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var binding1: ListItemBinding
    private var items: ArrayList<Item> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding1 = ListItemBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.Add.setOnClickListener{
            hideKeyboard();
            val Price = binding.PriceInput.text.toString()
            val Name = binding.ItemInput.text.toString()
            val URL = binding.URLInput.text.toString()

            binding.PriceInput.setText("")
            binding.ItemInput.setText("")
            binding.URLInput.setText("")

           // val smallItem = Item (Price, Name, URL)
            items.add(Item (Price, Name, URL))

            binding.ItemsRv.adapter = ItemAdapter(items)

            binding.ItemsRv.layoutManager = LinearLayoutManager(this)
        }

    }
}

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}









/*
      fun getItems(): MutableList<Item> {
          val Items: MutableList<Item> = ArrayList()
          for (i in 0..9) {
              val item = Item(Price[i], Item[i], URL[i])
              Items.add(item)
          }
          return Items
      }

      fun addItem(): MutableList<Item> {
          val newItem: MutableList<Item> = ArrayList()
          for (i in 10..14) {
              val item = Item(Price[i], Item[i], URL[i])
              newItem.add(item)
          }
          return newItem
      }

      val itemsRv = findViewById<RecyclerView>(R.id.ItemsRv)
      items = getItems()
      val adapter = ItemAdapter(items)
      itemsRv.adapter = adapter
      itemsRv.layoutManager = LinearLayoutManager(this)

      val addBtn = findViewById<Button>(R.id.Add)
*/
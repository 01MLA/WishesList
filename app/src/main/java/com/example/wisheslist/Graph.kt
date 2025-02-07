package com.example.wisheslist

import android.content.Context
import androidx.room.Room
import com.example.wisheslist.data.WishDatabase
import com.example.wisheslist.data.Wishrepository

object Graph {
    lateinit var database: WishDatabase
    val wishrepository by lazy { Wishrepository(wishDao = database.wishDao()) }

    fun provide(context: Context) {
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.dp").build()
    }
}
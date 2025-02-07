package com.example.wisheslist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wisheslist.data.Wish
import com.example.wisheslist.data.Wishrepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishrepository: Wishrepository = Graph.wishrepository,
) : ViewModel() {
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onWishTitleChanged(newStr: String) {
        wishTitleState = newStr
    }

    fun onWishDescriptionChanged(newStr: String) {
        wishDescriptionState = newStr
    }

    lateinit var getAllWishes: Flow<List<Wish>>

    init {
        viewModelScope.launch {
            getAllWishes = wishrepository.getWishes()
        }
    }

    fun addWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {// dispatchers are used to decide what thread
            wishrepository.addAWish(wish)
        }
    }

    fun getAWishById(id: Long): Flow<Wish> {
        return wishrepository.getAWishById(id)
    }

    fun updateWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {// dispatchers are used to decide what thread
            wishrepository.updateAWish(wish)
        }
    }

    fun deleteWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {// dispatchers are used to decide what thread
            wishrepository.deleteAWish(wish)
        }
    }

    fun main() {
        val number: IntArray = intArrayOf(10, 2, 3, 4)
        number.size
    }
}
package com.example.wisheslist.data

import kotlinx.coroutines.flow.Flow

class Wishrepository(private val wishDao: WishDao) {

    suspend fun addAWish(wish: Wish) {
        wishDao.addWish(wish)
    }

    fun getWishes(): Flow<List<Wish>> = wishDao.getAllWishes()

    fun getAWishById(id: Long): Flow<Wish> {
        return wishDao.getWishesById(id)
    }

    suspend fun updateAWish(wish: Wish) {
        wishDao.updateAWish(wish)
    }

    suspend fun deleteAWish(wish: Wish) {
        wishDao.deleteAWish(wish)
    }
}
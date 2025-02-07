package com.example.wisheslist.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addWish(wishEntity: Wish)

    // Load all wishes from the table wish-table
    @Query("SELECT * FROM 'wish-table'")
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Update
    abstract fun updateAWish(wishEntity: Wish)

    @Delete
    abstract suspend fun deleteAWish(wishEntity: Wish)

    @Query("SELECT * FROM 'wish-table' WHERE id=:id")
    abstract fun getWishesById(id: Long): Flow<Wish>

}
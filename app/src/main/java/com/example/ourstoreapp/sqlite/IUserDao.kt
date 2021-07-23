package com.example.ourstoreapp.sqlite

import androidx.room.*
import com.example.ourstoreapp.datamodel.user.User
import kotlinx.coroutines.flow.Flow

@Dao
interface IUserDao {

    @Query("SELECT * FROM user")
    fun getAllUser(): Flow<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: User)

    @Query("DELETE FROM user")
    suspend fun deleteAllUser()

    @Delete
    suspend fun deleteUserByKey(user: User)
}
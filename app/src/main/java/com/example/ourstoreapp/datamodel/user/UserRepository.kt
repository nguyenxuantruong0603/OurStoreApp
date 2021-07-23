package com.example.ourstoreapp.datamodel.user

import androidx.annotation.WorkerThread
import com.example.ourstoreapp.sqlite.IUserDao
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: IUserDao) {
    val listAllUser: Flow<List<User>> = userDao.getAllUser()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(user: User){
        userDao.insertUser(user)
    }
}
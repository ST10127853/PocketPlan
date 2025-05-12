package com.example.pocketplan.data.repository


import com.example.pocketplan.data.dao.UserDao
import models.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
) {
    suspend fun registerUser(user: User) = userDao.insertUser(user)

    suspend fun updateUser(user: User) = userDao.updateUser(user)

    suspend fun getUserByEmail(email: String) = userDao.getUserByEmail(email)

    fun getUserById(userId: Int) = userDao.getUserById(userId)
}
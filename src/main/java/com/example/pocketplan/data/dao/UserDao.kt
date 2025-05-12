package com.example.pocketplan.data.dao



import androidx.room.*
import kotlinx.coroutines.flow.Flow
import models.User

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: com.example.pocketplan.data.entities.User): Long

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM users WHERE id = :userId")
    fun getUserById(userId: Int): Flow<User>

    @Query("SELECT * FROM users WHERE email = :email")
    suspend fun getUserByEmail(email: String): User?
}
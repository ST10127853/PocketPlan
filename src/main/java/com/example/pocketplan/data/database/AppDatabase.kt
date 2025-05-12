package com.example.pocketplan.data.database

import androidx.room.Database
import androidx.room.Room
import android.content.Context
import androidx.room.RoomDatabase
import com.example.pocketplan.data.dao.BudgetGoalDao
import com.example.pocketplan.data.dao.CategoryDao
import com.example.pocketplan.data.dao.ExpenseDao
import com.example.pocketplan.data.dao.UserDao
import com.example.pocketplan.data.entities.BudgetGoal
import com.example.pocketplan.data.entities.Category
import com.example.pocketplan.data.entities.Expense
import com.example.pocketplan.data.entities.User

@Database(
    entities = [User::class, Category::class, Expense::class, BudgetGoal::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun categoryDao(): CategoryDao
    abstract fun expenseDao(): ExpenseDao
    abstract fun budgetGoalDao(): BudgetGoalDao
}

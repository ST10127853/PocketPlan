package com.example.pocketplan.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pocketplan.data.dao.BudgetGoalDao
import com.example.pocketplan.data.dao.CategoryDao
import com.example.pocketplan.data.dao.ExpenseDao
import com.example.pocketplan.data.dao.UserDao
import com.example.pocketplan.data.entities.BudgetGoal
import com.example.pocketplan.data.entities.Category
import com.example.pocketplan.data.entities.Expense
import com.example.pocketplan.data.entities.User
import kotlinx.serialization.serializer
import kotlinx.serialization.serializerOrNull

@Database(
    entities = [User::class, Category::class, Expense::class, BudgetGoal::class],
    version = 1
)
abstract class AppDataeDaobase : RoomDatabase() {
        abstract fun userDao(): UserDao
        abstract fun categoryDao(): CategoryDao
        abstract fun expenseDao(): Expense
    abstract fun budgetGoalDao(): BudgetGoalDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "pocket_plan_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
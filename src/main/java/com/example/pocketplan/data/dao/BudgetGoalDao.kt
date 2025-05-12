package com.example.pocketplan.data.dao

import androidx.room.*

import kotlinx.coroutines.flow.Flow
import models.BudgetGoal

@Dao
interface BudgetGoalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateBudgetGoal(budgetGoal: BudgetGoal): Long

    @Delete
    suspend fun deleteBudgetGoal(budgetGoal: BudgetGoal)

    @Query("SELECT * FROM budget_goals WHERE userId = :userId AND month = :month AND year = :year")
    suspend fun getBudgetGoalForMonth(userId: Long, month: Int, year: Int): BudgetGoal?

    @Query("SELECT * FROM budget_goals WHERE userId = :userId ORDER BY year DESC, month DESC")
    fun getAllBudgetGoalsForUser(userId: Long): Flow<List<BudgetGoal>>
}
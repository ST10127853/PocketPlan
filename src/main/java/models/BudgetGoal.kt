package models

data class BudgetGoal(
    val id: Int = 0,
    val userId: Int,
    val categoryId: Int,
    val minimumAmount: Double,
    val maximumAmount: Double,
    val period: String // MONTHLY, WEEKLY, etc.
)
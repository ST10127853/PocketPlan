package models

data class Expense(
    val id: Int = 0,
    val amount: Double,
    val description: String,
    val date: Long,
    val categoryId: Int,
    val userId: Int,
    val photoPath: String? = null
)
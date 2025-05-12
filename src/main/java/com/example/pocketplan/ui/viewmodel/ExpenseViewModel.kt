package com.example.pocketplan.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import models.Expense

class ExpenseViewModel(private val expenseDao: ExpenseDao) : ViewModel() {
    fun getAllExpenses(userId: Int): LiveData<List<Expense>> = expenseDao.getAllExpenses(userId)

    fun addExpense(expense: Expense) = viewModelScope.launch {
        expenseDao.insert(expense)
    }

    fun deleteExpense(expense: Expense) = viewModelScope.launch {
        expenseDao.delete(expense)
    }
}
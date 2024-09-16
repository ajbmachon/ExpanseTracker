package org.expense.org.expense.repository

import org.expense.models.Expense

interface ExpenseRepository {
    fun addExpense(expense: Expense)
    fun getAllExpenses(): List<Expense>
    fun getExpenseById(id: Int): Expense?
    fun updateExpense(expense: Expense): Boolean
    fun deleteExpense(id: Int): Boolean
}
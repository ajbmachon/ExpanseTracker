package org.expense.org.expense.repository

import org.expense.models.Expense

class InMemoryExpenseRepository: ExpenseRepository {
    override fun addExpense(expense: Expense) {
        TODO("Not yet implemented")
    }

    override fun getAllExpenses(): List<Expense> {
        TODO("Not yet implemented")
    }

    override fun getExpenseById(id: Int): Expense? {
        TODO("Not yet implemented")
    }

    override fun updateExpense(expense: Expense): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteExpense(id: Int): Boolean {
        TODO("Not yet implemented")
    }
}
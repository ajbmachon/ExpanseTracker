package org.expense.models

import java.time.LocalDate


data class Category(
    val name: String,
    val description: String? = null, // Optional description for the category
    val parentCategory: Category? = null // Optional parent category for subcategories
) {
    init {
        require(name.isNotBlank()) { "Category name cannot be blank" }
    }
}

data class Discount(
    val percentage: Double,
    val startDate: LocalDate,
    val endDate: LocalDate // Date when the discount expires
)

enum class RecurrenceFrequency {
    DAILY, WEEKLY, MONTHLY, YEARLY
}

enum class ExpenseType {
    SINGLE, RECURRING
}

data class Expense(
    val description: String,
    val amount: Double,
    val category: Category,
    val date: LocalDate,
    val type: ExpenseType,
    val recurrenceFrequency: RecurrenceFrequency? = null, // Optional for recurring expenses
    val discount: Discount? = null // Optional discount for recurring expenses
)

data class RecurringExpense(
    val expense: Expense,
    val startDate: LocalDate,
    val endDate: LocalDate? = null, // Optional end date for the recurring expense
    val recurrenceInterval: RecurrenceFrequency // Frequency of recurrence
)

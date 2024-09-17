package org.expense.factory

import java.time.LocalDate
import org.expense.models.Category
import org.expense.models.Expense
import org.expense.models.ExpenseType
import org.expense.models.RecurringExpense
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun createExpense(
    description: String,
    amount: Double,
    category: Category,
    date: LocalDate? = null,
): Expense {
    require(description.length > 2) { "Description must be at least 3 characters long" }
    require(description.isNotBlank()) { "Description cannot be blank" }
    require(amount > 0) { "Amount must be greater than zero" }

    return Expense(description, amount, category, date ?: LocalDate.now(), ExpenseType.SINGLE).also {
        logger.debug { "Expense object $it was created by function: ${::createExpense}" }
    }
}

fun createRecurringExpense(): RecurringExpense = TODO()


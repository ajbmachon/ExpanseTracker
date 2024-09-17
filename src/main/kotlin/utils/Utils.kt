package org.expense.utils

import org.expense.models.Expense

fun Expense.format(fullData: Boolean = true, shortenDescription: Boolean = false): String {
    val formattedDescription = if (shortenDescription && description.length > 30) {
        description.take(30) + "..."
    } else description
    return if (fullData) {
        "Description: $formattedDescription, Amount: $amount, Category: ${category.name}, Date: $date"
    } else {
        "Amount: $amount, Category: $category"
    }
}
package org.expense.cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.Context
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required
import com.github.ajalt.clikt.parameters.options.validate
import com.github.ajalt.clikt.parameters.types.double
import org.expense.factory.createExpense
import org.expense.models.Category
import org.expense.utils.format


class Root: CliktCommand() {
    override fun run() = Unit
}

class Expense: CliktCommand(name = "expense") {
    override fun run() = Unit
} // todo use this as top level command before add when the application gets other cli command trees
class Add: CliktCommand() {
    val description by option("-d", "--description", help="description for the expense",).required()
    val amount: Double by option("-a", "--amount", help="amount of the expense, must be a positive number",)
        .double()
        .required()
        .validate { require(it > 0) {"Amount must be a positive number"} }
    val categoryName by option("-c", "--category", help="category the expense belongs to",).required()
    override fun run() {
        val expense = createExpense(
            description,
            amount,
            Category(categoryName),
        )
        echo("You added an expense for:\n" + expense.format(shortenDescription = true))
    }
}

// todo add commands for viewing expenses, then deleting them

val expenseCmd = Root().subcommands(Add())
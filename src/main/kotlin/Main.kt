package org.expense

import com.github.ajalt.clikt.core.main
import com.github.ajalt.clikt.core.subcommands
import org.expense.cli.expenseCmd
import org.expense.cli.Expense
import org.expense.cli.Add

fun startWebServer() {
    TODO("Not yet implemented")
}

fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        expenseCmd.main(args) // Run CLI if arguments are provided
    } else {
        // Run the web API if no arguments are provided
        startWebServer()
    }
}



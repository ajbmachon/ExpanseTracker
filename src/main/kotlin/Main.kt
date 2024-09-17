package org.expense

import com.github.ajalt.clikt.core.main
import org.expense.cli.expenseCmd

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



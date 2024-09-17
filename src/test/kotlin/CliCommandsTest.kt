import com.github.ajalt.clikt.testing.test
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

import org.expense.cli.expenseCmd

class CliCommandsTest {
    @Test
    fun `test adding an expanse with only required parameters`() {
        var result = expenseCmd.test("add --description 'A Pizza' --amount 23 --category Food")
        assertTrue(result.stdout.isNotEmpty())
        assertTrue(result.stdout.contains("Description: A Pizza, Amount: 23.0, Category: Food"))

        result = expenseCmd.test("add -dBread -a4.55 -cFood")
        assertTrue(result.stdout.contains("Description: Bread, Amount: 4.55, Category: Food"))
    }
}
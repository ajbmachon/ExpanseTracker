import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

import org.expense.factory.createExpense
import org.expense.models.Category
import java.time.LocalDate
import kotlin.test.assertFailsWith

class FactoryFunctionsTest {

    @Test
    fun `test valid expense creation`() {
        val expense = createExpense(
            "A five pack of pizza",
            20.99,
            Category("Food")
        )

        assertEquals("Food", expense.category.name)

        // Allow a tolerance check for the date since LocalDate.now() can differ slightly
        assertTrue(expense.date.isEqual(LocalDate.now()), "Date was not set to the current date")

        // Edge case for a large amount
        val largeExpense = createExpense("Luxury Car", 1000000.99, Category("Luxury"))
        assertEquals(1000000.99, largeExpense.amount)

        // Edge case for a long description
        val longDescription = "A".repeat(1000)
        val longDescriptionExpense = createExpense(longDescription, 150.0, Category("Miscellaneous"))
        assertEquals(longDescription, longDescriptionExpense.description)
    }

    @Test
    fun `test invalid expense creation`() {
        // Invalid descriptions (empty, too short, only spaces)
        assertFailsWith<IllegalArgumentException> {
            createExpense("", 20.99, Category("Food"))
        }
        assertFailsWith<IllegalArgumentException> {
            createExpense("td", 20.99, Category("Food")) // Too short
        }
        assertFailsWith<IllegalArgumentException> {
            createExpense("   ", 20.99, Category("Food")) // Only spaces
        }

        // Invalid amounts (negative and zero)
        assertFailsWith<IllegalArgumentException> {
            createExpense("Tea", -20.0, Category("Food"))
        }
        assertFailsWith<IllegalArgumentException> {
            createExpense("Coffee", 0.0, Category("Beverages")) // Zero amount
        }

        // Invalid category (blank category name)
        assertFailsWith<IllegalArgumentException> {
            createExpense("Sandwich", 5.0, Category(""))
        }
    }
}

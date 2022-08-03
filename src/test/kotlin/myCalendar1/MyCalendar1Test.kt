package myCalendar1

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class MyCalendar1Test {
    private val myCalendar1 = MyCalendar1()

    @Test
    fun book() {
        assertTrue(myCalendar1.book(10, 20))
        assertFalse(myCalendar1.book(15, 25))
        assertTrue(myCalendar1.book(20, 30))
    }
}

package xurxodev.com.kataloginlogout

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LogOutShould {

    @Test
    fun `return true current millisecond is even`() {
        val logOut = LogOut(ValidTimeProvider())

        val result = logOut.performLogOut()

        assertTrue(result)
    }

    @Test
    fun `return false current millisecond is odd`() {
        val logOut = LogOut(InvalidTimeProvider())

        val result = logOut.performLogOut()

        assertFalse(result)
    }
}
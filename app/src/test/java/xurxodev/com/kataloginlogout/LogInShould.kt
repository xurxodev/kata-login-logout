package xurxodev.com.kataloginlogout

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LogInShould {
    @Test
    fun `return true if username is admin and password is admin`() {
        val logIn = LogIn()

        val result = logIn.performLogIn("admin", "admin")

        assertTrue(result)
    }

    @Test
    fun `return false if username is empty and password is empty`() {
        val logIn = LogIn()

        val result = logIn.performLogIn("", "")

        assertFalse(result)
    }

    @Test
    fun `return true if username is admin and password is not admin`() {
        val logIn = LogIn()

        val result = logIn.performLogIn("admin", "no admin")

        assertFalse(result)
    }

    @Test
    fun `return true if username is not admin and password is admin`() {
        val logIn = LogIn()

        val result = logIn.performLogIn("no admin", "admin")

        assertFalse(result)
    }
}
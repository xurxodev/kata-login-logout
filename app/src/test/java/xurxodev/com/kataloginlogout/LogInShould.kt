package xurxodev.com.kataloginlogout

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LogInShould {

    companion object {
        private const val ANY_INVALID_PASSWORD = "password"
        private const val ANY_VALID_PASSWORD = "admin"
        private const val ANY_INVALID_USERNAME = "username"
        private const val ANY_VALID_USERNAME = "admin"
    }

    @Test
    fun `return true if username is admin and password is admin`() {
        val logIn = LogIn()

        val result = logIn.performLogIn(ANY_VALID_USERNAME, ANY_VALID_PASSWORD)

        assertTrue(result)
    }

    @Test
    fun `return false if username is empty and password is empty`() {
        val logIn = LogIn()

        val result = logIn.performLogIn(ANY_INVALID_USERNAME, ANY_INVALID_PASSWORD)

        assertFalse(result)
    }

    @Test
    fun `return true if username is admin and password is not admin`() {
        val logIn = LogIn()

        val result = logIn.performLogIn(ANY_VALID_USERNAME, ANY_INVALID_PASSWORD)

        assertFalse(result)
    }

    @Test
    fun `return true if username is not admin and password is admin`() {
        val logIn = LogIn()

        val result = logIn.performLogIn(ANY_INVALID_USERNAME, ANY_VALID_PASSWORD)

        assertFalse(result)
    }
}
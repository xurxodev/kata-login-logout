package xurxodev.com.kataloginlogout

import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LogOutShould {

    @Mock
    lateinit var timeProvider: TimeProvider

    @Test
    fun `return true current millisecond is even`() {
        val logOut = givenALogOut(2)

        val result = logOut.performLogOut()

        assertTrue(result)
    }

    @Test
    fun `return false current millisecond is odd`() {
        val logOut = givenALogOut(3)

        val result = logOut.performLogOut()

        assertFalse(result)
    }

    private fun givenALogOut(nowMillis: Long): LogOut {
        whenever(timeProvider.getCurrentMillis()).thenReturn(nowMillis)

        return LogOut(timeProvider)
    }
}
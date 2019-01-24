package xurxodev.com.kataloginlogout

import com.nhaarman.mockitokotlin2.whenever
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PresenterShould {

    @Mock
    lateinit var timeProvider: TimeProvider

    companion object {
        private const val ANY_INVALID_PASSWORD = "password"
        private const val ANY_VALID_PASSWORD = "admin"
        private const val ANY_INVALID_USERNAME = "username"
        private const val ANY_VALID_USERNAME = "admin"
    }

    @Mock
    private lateinit var view: Presenter.View

    @Test
    fun `show logOut and login success message if credentials is valid`() {
        val presenter = givenAPresenterWithValidLogOut()

        presenter.attachView(view)

        presenter.onLogIn(ANY_VALID_USERNAME, ANY_VALID_PASSWORD)

        verify(view).showLogOutForm()
        verify(view).showLogInSuccessMessage()
    }

    @Test
    fun `show login error message if credentials is invalid`() {
        val presenter = givenAPresenterWithValidLogOut()

        presenter.attachView(view)

        presenter.onLogIn(ANY_INVALID_USERNAME, ANY_INVALID_PASSWORD)

        verify(view).showLogInErrorMessage()
    }

    @Test
    fun `show logIn form if millis on logout is valid`() {
        val presenter = givenAPresenterWithValidLogOut()

        presenter.attachView(view)

        presenter.onLogOut()

        verify(view).showLogInForm()
        verify(view).hideLogOutForm()
    }

    @Test
    fun `show logout error message if millis on logout is invalid`() {
        val presenter = givenAPresenterWithInvalidLogOut()

        presenter.attachView(view)

        presenter.onLogOut()

        verify(view).showLogOutErrorMessage()
    }

    private fun givenAPresenterWithValidLogOut(): Presenter {
        val logIn = LogIn()
        val logOut = givenALogOut(2)
        return Presenter(logIn, logOut)
    }

    private fun givenAPresenterWithInvalidLogOut(): Presenter {
        val logIn = LogIn()
        val logOut = givenALogOut(3)
        return Presenter(logIn, logOut)
    }

    private fun givenALogOut(nowMillis: Long): LogOut {
        whenever(timeProvider.getCurrentMillis()).thenReturn(nowMillis)

        return LogOut(timeProvider)
    }
}
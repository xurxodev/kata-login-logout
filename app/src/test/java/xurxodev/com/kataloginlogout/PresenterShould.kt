package xurxodev.com.kataloginlogout

import junit.framework.Assert.fail
import org.junit.Test

class PresenterShould {
    @Test
    fun `show logOut form and login success message if credentials is valid`() {
        val presenter = givenAPresenterWithValidLogOut()

        val view = object : Presenter.View {
            override fun showLogInForm() {
                fail()
            }

            override fun hideLogInForm() {
                assert(true)
            }

            override fun showLogOutForm() {
                assert(true)
            }

            override fun hideLogOutForm() {
                fail()
            }

            override fun showLogInSuccessMessage() {
                assert(true)
            }

            override fun showLogInErrorMessage() {
                fail()
            }

            override fun showLogOutErrorMessage() {
                fail()
            }
        }

        presenter.attachView(view)

        presenter.onLogIn("admin", "admin")
    }

    @Test
    fun `show login error message if credentials is invalid`() {
        val presenter = givenAPresenterWithValidLogOut()

        val view = object : Presenter.View {
            override fun showLogInForm() {
                fail()
            }

            override fun hideLogInForm() {
                fail()
            }

            override fun showLogOutForm() {
                fail()
            }

            override fun hideLogOutForm() {
                fail()
            }

            override fun showLogInSuccessMessage() {
                fail()
            }

            override fun showLogInErrorMessage() {
                assert(true)
            }

            override fun showLogOutErrorMessage() {
                fail()
            }
        }

        presenter.attachView(view)

        presenter.onLogIn("admin", "no admin")
    }

    @Test
    fun `show logIn form if millis on logout is valid`() {
        val presenter = givenAPresenterWithValidLogOut()

        val view = object : Presenter.View {
            override fun showLogInForm() {
                assert(true)
            }

            override fun hideLogInForm() {
                fail()
            }

            override fun showLogOutForm() {
                fail()
            }

            override fun hideLogOutForm() {
                assert(true)
            }

            override fun showLogInSuccessMessage() {
                fail()
            }

            override fun showLogInErrorMessage() {
                fail()
            }

            override fun showLogOutErrorMessage() {
                fail()
            }
        }

        presenter.attachView(view)

        presenter.onLogOut()
    }

    @Test
    fun `show logout error message if millis on logout is invalid`() {
        val presenter = givenAPresenterWithInvalidLogOut()

        val view = object : Presenter.View {
            override fun showLogInForm() {
                fail()
            }

            override fun hideLogInForm() {
                fail()
            }

            override fun showLogOutForm() {
                fail()
            }

            override fun hideLogOutForm() {
                fail()
            }

            override fun showLogInSuccessMessage() {
                fail()
            }

            override fun showLogInErrorMessage() {
                fail()
            }

            override fun showLogOutErrorMessage() {
                assert(true)
            }
        }

        presenter.attachView(view)

        presenter.onLogOut()
    }

    private fun givenAPresenterWithValidLogOut(): Presenter {
        val logIn = LogIn()
        val logOut = LogOut(ValidTimeProvider())
        return Presenter(logIn, logOut)
    }

    private fun givenAPresenterWithInvalidLogOut(): Presenter {
        val logIn = LogIn()
        val logOut = LogOut(InvalidTimeProvider())
        return Presenter(logIn, logOut)
    }
}
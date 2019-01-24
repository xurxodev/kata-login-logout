package xurxodev.com.kataloginlogout

import android.app.Activity
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class MainActivity : AppCompatActivity(), Presenter.View {

    private val logIn = LogIn()
    private val logOut = LogOut(Timer())
    private val presenter = Presenter(logIn, logOut)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter.attachView(this)

        login_button.setOnClickListener {
            presenter.onLogIn(
                login_username.text.toString(),
                login_password.text.toString()
            )
        }

        logout_button.setOnClickListener {
            presenter.onLogOut()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    private fun showMessage(@StringRes stringId: Int) {
        Toast.makeText(this, stringId, Toast.LENGTH_SHORT)
            .show()
    }

    private fun hideKeyboard() {
        val imm = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(login_password.windowToken, 0)
    }

    override fun showLogInForm() {
        login_container.visibility = View.VISIBLE
    }

    override fun hideLogInForm() {
        login_container.visibility = View.GONE
    }

    override fun showLogOutForm() {
        hideKeyboard()
        logout_container.visibility = View.VISIBLE
    }

    override fun hideLogOutForm() {
        logout_container.visibility = View.GONE
    }

    override fun showLogInSuccessMessage() {
        showMessage(R.string.login_success_message)
    }

    override fun showLogInErrorMessage() {
        showMessage(R.string.login_error_message)
    }

    override fun showLogOutErrorMessage() {
        showMessage(R.string.logout_not_available_message)
    }
}

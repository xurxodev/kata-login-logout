package xurxodev.com.kataloginlogout

import android.app.Activity
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val logIn = LogIn()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button.setOnClickListener {
            if (logIn.performLogIn(
                    login_username.text.toString(),
                    login_password.text.toString())) {
                showMessage(R.string.login_success_message)
                login_container.visibility = View.GONE
                logout_container.visibility = View.VISIBLE
                hideKeyboard()
            } else {
                showMessage(R.string.login_error_message)
            }
        }

        logout_button.setOnClickListener {
            val millis = System.currentTimeMillis()

            if (millis % 2L == 0L) {
                login_container.visibility = View.VISIBLE
                logout_container.visibility = View.GONE
            } else {
                showMessage(R.string.logout_not_available_message)
            }
        }
    }

    // solo logout si el milisegundo es par

    private fun showMessage(@StringRes stringId: Int) {
        Toast.makeText(this, stringId, Toast.LENGTH_SHORT)
            .show()
    }

    fun hideKeyboard() {
        val imm = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(login_password.windowToken, 0)
    }
}

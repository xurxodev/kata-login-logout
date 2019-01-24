package xurxodev.com.kataloginlogout

class Presenter(private val logIn: LogIn, val logOut: LogOut) {
    var view: View? = null

    fun attachView(view: View) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }

    fun onLogIn(username: String, password: String) {
        if (logIn.performLogIn(username, password)) {
            view?.showLogInSuccessMessage()
            view?.hideLogInForm()
            view?.showLogOutForm()
        } else {
            view?.showLogInErrorMessage()
        }
    }

    fun onLogOut() {
        if (logOut.performLogOut()) {
            view?.showLogInForm()
            view?.hideLogOutForm()
        } else {
            view?.showLogOutErrorMessage()
        }
    }

    interface View {
        fun showLogInForm()
        fun hideLogInForm()
        fun showLogOutForm()
        fun hideLogOutForm()

        fun showLogInSuccessMessage()
        fun showLogInErrorMessage()
        fun showLogOutErrorMessage()
    }
}
package xurxodev.com.kataloginlogout

class LogIn {
    companion object {
        private const val ALLOWED_CREDENTIALS = "admin"
    }

    fun performLogIn(username: String, password: String): Boolean =
        username == ALLOWED_CREDENTIALS && password == ALLOWED_CREDENTIALS
}
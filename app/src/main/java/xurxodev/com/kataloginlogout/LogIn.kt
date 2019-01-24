package xurxodev.com.kataloginlogout

class LogIn {
    fun performLogin(username: String, password: String): Boolean =
        username == "admin" && password == "admin"
}
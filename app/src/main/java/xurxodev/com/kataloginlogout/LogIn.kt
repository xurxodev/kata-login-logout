package xurxodev.com.kataloginlogout

class LogIn {
    fun performLogIn(username: String, password: String): Boolean =
        username == "admin" && password == "admin"
}
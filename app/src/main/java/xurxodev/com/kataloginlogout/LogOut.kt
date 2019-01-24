package xurxodev.com.kataloginlogout

class LogOut(private val timer: TimeProvider) {
    fun performLogOut(): Boolean = timer.getCurrentMillis() % 2L == 0L
}
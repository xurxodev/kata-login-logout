package xurxodev.com.kataloginlogout

interface TimeProvider {
    fun getCurrentMillis(): Long
}

class Timer : TimeProvider {
    override fun getCurrentMillis() = System.currentTimeMillis()
}
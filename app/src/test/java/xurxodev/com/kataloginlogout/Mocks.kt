package xurxodev.com.kataloginlogout

class ValidTimeProvider : TimeProvider {
    override fun getCurrentMillis(): Long = 2
}

class InvalidTimeProvider : TimeProvider {
    override fun getCurrentMillis(): Long = 1
}
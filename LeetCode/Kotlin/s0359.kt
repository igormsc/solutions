class Logger359() {

    private val limiter = mutableMapOf<String, Int>()

    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        if ((limiter[message]?:0) > timestamp) return false
        limiter[message] = timestamp + 10
        return true
    }

}
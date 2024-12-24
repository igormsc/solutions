class PhoneDirectory(maxNumbers: Int) {

    private val available = mutableSetOf<Int>()

    init {
        (0..<maxNumbers).forEach{ available.add(it) }
    }

    fun get(): Int {
        if (available.isEmpty()) return -1
        val x = available.iterator().next()
        available.remove(x)
        return x
    }

    fun check(number: Int): Boolean = available.contains(number)

    fun release(number: Int) = available.add(number)

}
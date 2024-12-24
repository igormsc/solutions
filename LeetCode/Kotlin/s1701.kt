class Solution1701 {
    fun averageWaitingTime(customers: Array<IntArray>): Double {
        var cur = 0L
        return customers.sumOf { c ->
            val c0 = c[0].toLong()
            if (c0 > cur) cur = c0
            cur += c[1].toLong()
            cur - c0
        }.let { it.toDouble() / customers.size.toDouble() }
    }
}

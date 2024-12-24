class Solution3184 {
    fun countCompleteDayPairs(hours: IntArray): Int {
        val m = mutableMapOf<Int, Int>()
        return hours.sumOf{ h ->
            val x = m[(24 - h%24)%24]?:0
            m[h%24] = (m[h%24]?:0) + 1
            x }
    }
}


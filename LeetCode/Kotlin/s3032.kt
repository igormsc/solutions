class Solution3032 {
    fun numberCount(a: Int, b: Int): Int = (a..b).count{ isValid(it) }

    private fun isValid(n: Int): Boolean {
        var n = n
        val p = BooleanArray(10)
        while (n > 0) {
            val d = n % 10
            if (p[d]) return false
            p[d] = true
            n /= 10
        }
        return true
    }

}
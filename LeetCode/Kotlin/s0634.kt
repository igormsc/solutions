class Solution634 {
    fun findDerangement(n: Int): Int {
        val mod = 1_000_000_007L
        var (a, b) = 1L to 0L
        for (i in 2..n) {
            val c = (i - 1) * (a + b) % mod
            a = b
            b = c
        }
        return b.toInt()
    }

}
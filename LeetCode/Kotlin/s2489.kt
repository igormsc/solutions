class Solution2489 {
    fun fixedRatio(s: String, num1: Int, num2: Int): Long {
        var (n0, n1, res) = longArrayOf(0, 0, 0)
        val cnt = mutableMapOf(0L to 1L)
        for (c in s.toCharArray()) {
            if (c == '0') n0++
            if (c == '1') n1++
            val x = n1 * num1.toLong() - n0 * num2.toLong()
            res += cnt[x]?:0L
            cnt[x] = (cnt[x]?:0L)  + 1L
        }
        return res
    }

}
class Solution2557 {
    fun maxCount(banned: IntArray, n: Int, maxSum: Long): Int {
        var maxSum = maxSum
        val black = mutableSetOf(0,n+1)
        banned.forEach{ black.add(it)}
        val ban = black.toIntArray()
        ban.sort()
        var res = 0
        for (k in 1..ban.lastIndex) {
            val i = ban[k - 1]
            val j = ban[k]
            var (l, r) = 0 to j - i - 1
            while (l < r) {
                val mid = (l + r + 1) ushr 1
                if ((i + 1 + i + mid) * 1L * mid / 2 <= maxSum) l = mid
                else r = mid - 1
            }
            res += l
            maxSum -= (i + 1 + i + l) * 1L * l / 2
            if (maxSum <= 0) break
        }
        return res
    }

}
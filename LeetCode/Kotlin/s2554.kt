class Solution2554 {
    fun maxCount(banned: IntArray, n: Int, maxSum: Int): Int {
        val s = banned.toSet()
        var x = 1
        var maxSum = maxSum
        var res = 0
        while (x<=n && maxSum >= 0) {
            if (!s.contains(x)) {
                maxSum -=x
                if (maxSum >= 0) res++
            }
            x++
        }
        return res
    }
}

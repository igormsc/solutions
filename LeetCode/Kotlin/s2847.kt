class Solution2847 {
    fun smallestNumber(n: Long): String {
        var n = n
        val cnt = IntArray(10)
        for (i in 9 downTo 2) {
            while (n % i == 0L) {
                cnt[i]++
                n /= i.toLong()
            }
        }
        if (n > 1) return "-1"
        val sb = StringBuilder()
        for (i in 2..9) {
            while (cnt[i] > 0) {
                sb.append(i)
                cnt[i]--
            }
        }
        return sb.toString().ifEmpty { "1" }
    }

}
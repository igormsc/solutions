class Solution2802 {
    fun kthLuckyNumber(k: Int): String {
        var k = k
        var n = 1
        while (k > 1 shl n) k -= 1 shl n++

        val sb = StringBuilder()
        while (n-- > 0) {
            if (k <= 1 shl n) sb.append('4')
            else {
                sb.append('7')
                k -= 1 shl n
            }
        }
        return sb.toString()
    }

}
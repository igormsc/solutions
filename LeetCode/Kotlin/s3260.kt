class Solution3260 {
    fun largestPalindrome(n: Int, k: Int): String =
        when (k) {
            1, 3, 9 -> "9".repeat(n)
            2 -> if (n == 1) "8" else "8" + "9".repeat(n-2) + "8"
            4 -> if (n<4) "8".repeat(n) else "8".repeat(2) + "9".repeat(n-4) + "8".repeat(2)
            5 -> if (n==1) "5" else "5" + "9".repeat(n-2) + "5"
            6 -> if (n<3) "6".repeat(n) else "8" + "9".repeat((n-3)/2) + (if (n%2!=0) "8" else "7").repeat(if (n%2!=0) 1 else 2) +  "9".repeat((n-3)/2) + "8"
            8 -> if (n<7) "8".repeat(n) else "8".repeat(3) + "9".repeat(n-6) + "8".repeat(3)
            else -> {
                val res = (if(n<3) "7" else "9").repeat(n).toCharArray()
                var i = 8
                while (i>=0 && !div7(res.joinToString(""))) {
                    val c = ('0'.code + i).toChar()
                    res[(n-1)/2] = c
                    res[n/2] = c
                    i--
                }
                res.joinToString("")
            }
        }

    private fun div7(s: String): Boolean {
        val id = intArrayOf(1, 3, 2, -1, -3, -2)
        return s.indices.sumOf{ i -> (s[i].code - '0'.code)*id[i%6].toLong() } % 7L == 0L
    }
}
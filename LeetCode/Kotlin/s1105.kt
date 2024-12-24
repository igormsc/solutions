class Solution1105 {
    fun minHeightShelves(books: Array<IntArray>, shelfWidth: Int): Int {
        val dp = IntArray(books.size+1)
        (1..books.size).forEach { p ->
            var i = p
            var w = 0
            var h = 0
            while (i > 0 && w+books[i-1][0] <= shelfWidth) {
                w += books[i-1][0]
                h = maxOf(h, books[i-1][1])
                if (dp[p] == 0) dp[p] = dp[i-1] + h
                else if (dp[i-1]+h < dp[p]) dp[p] = dp[i-1] + h
                i--
            }
        }
        return dp[dp.lastIndex]
    }

}

class Solution1395 {
    fun numTeams(rating: IntArray): Int =
        rating.foldIndexed(0) { i, t, x ->
            val l = (0..<i).count { rating[it] < x }
            val r = (i+1..rating.lastIndex).count { x < rating[it] }
            t + l*r + (i-l)*(rating.lastIndex - r - i)
    }
}


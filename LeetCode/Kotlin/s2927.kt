class Solution2927 {
    fun distributeCandies(n: Int, limit: Int): Long =
            if (n > 3 * limit) 0
            else comb2(n + 2) - (if (n > limit) 3 * comb2(n - limit + 1) else 0) + (if (n - 2 >= 2 * limit) 3 * comb2(n - 2 * limit) else 0)

        private fun comb2(n: Int): Long = 1L * n * (n - 1) / 2

}
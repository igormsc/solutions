class Solution2189 {
    fun houseOfCards(n: Int): Int {
        val f = Array(n + 1) { Array<Int?>(n / 3) {null} }

        fun dfs(n: Int, k: Int): Int {
            val x = 3 * k + 2
            if (x > n) return 0
            if (x == n) return 1
            if (f[n][k] != null) return f[n][k]!!
            return (dfs(n - x, k + 1) + dfs(n, k + 1)).also { f[n][k] = it }
        }

        return dfs(n, 0)
    }

}
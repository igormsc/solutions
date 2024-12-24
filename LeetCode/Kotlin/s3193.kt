class Solution3193 {
    fun numberOfPermutations(n: Int, requirements: Array<IntArray>): Int {
        val dp = Array(301){ IntArray(401) }

        fun dfs(i: Int, j: Int, cnt: Int): Int {
            var j = j
            if (j>=0 && requirements[j][0] == i) {
                if (requirements[j][1] != cnt) return 0
                j--
            }
            if (i == 0 || i*(i+1)/2 < cnt) return if (cnt==0) 1 else 0
            if (dp[i][cnt] == 0) {
                dp[i][cnt] = 1
                (0..minOf(i,cnt)).forEach { k -> dp[i][cnt] = (dp[i][cnt] + dfs(i-1, j, cnt-k)) % 1_000_000_007 }
            }
            return dp[i][cnt] - 1;
        }

        requirements.sortWith(compareBy({ it[0] }, { it[1] }))
        return dfs(n-1, requirements.lastIndex, requirements.last()[1])
    }
}

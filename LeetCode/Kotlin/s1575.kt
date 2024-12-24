import kotlin.math.absoluteValue

class Solution1575 {
    fun countRoutes(locations: IntArray, start: Int, finish: Int, fuel: Int): Int {
        val mod = 1_000_000_007
        val dp = Array(100) {IntArray(201){-1}}

        fun dfs(u: Int, v: Int, f: Int):Int  {
            if (dp[u][f] == -1) {
                var r = if (u==v) 1 else 0
                locations.indices.forEach {i ->
                    if (i != u && (locations[u]-locations[i]).absoluteValue <= f)
                        r = (r + dfs(i, v, f-(locations[u]-locations[i]).absoluteValue))%mod }
                dp[u][f] = r
            }
            return dp[u][f]
        }

        return dfs(start, finish, fuel)
    }
}

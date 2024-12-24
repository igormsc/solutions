import kotlin.math.absoluteValue

class Solution3149 {
    fun findPermutation(nums: IntArray): IntArray {
        val dp = Array(14){IntArray(16384){-1}}
        val vl = Array(14){IntArray(16384)}

        fun dfs(mask: Int, p: Int): Int {
            if (mask.countOneBits() == nums.size) return (p-nums[0]).absoluteValue
            if (dp[p][mask]<0) {
                dp[p][mask] = Int.MAX_VALUE
                (1..<nums.size).forEach { n ->
                    if (1.shl(n).and(mask) == 0) {
                        val r = (p-nums[n]).absoluteValue + dfs(mask + 1.shl(n), n)
                        if (r<dp[p][mask]) {
                            dp[p][mask] = r
                            vl[p][mask] = n
                        }
                    }
                }
            }
            return dp[p][mask]
        }
        dfs(1,0)
        val res = mutableListOf(0)
        var mask = 1
        while (mask.countOneBits() < nums.size) {
            res.add(vl[res.last()][mask])
            mask += 1.shl(res.last())
        }
        return res.toIntArray()
    }
}

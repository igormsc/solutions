class Solution698 {
    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        if (k > nums.size) return false
        val sum = nums.sum()
        if (sum % k != 0) return false
        val vis = BooleanArray(nums.size)
        nums.sort()

        fun dfs(s: Int, i: Int, to: Int, r: Int): Boolean =
            when {
                r == 0 -> true
                (s == to && dfs(0, nums.lastIndex, to, r - 1)) -> true
                else -> {
                    (i downTo 0).forEach { i ->
                        if (!vis[i] && s + nums[i] <= to) {
                            vis[i] = true
                            if (dfs(s + nums[i], i - 1, to, r)) return true
                            vis[i] = false
                        }
                    }
                    false
                }
            }
        return dfs(0, nums.lastIndex, sum / k, k)
    }
}

class Solution2459 {
    fun sortArray(nums: IntArray): Int {
        val n = nums.size
        val arr = IntArray(n)
        (0..<n).forEach { arr[it] = (nums[it] - 1 + n) % n }

        fun f(nums: IntArray, k: Int): Int {
            val vis = BooleanArray(nums.size)
            var cnt = 0
            for (i in nums.indices) {
                if (i == nums[i] || vis[i]) continue
                cnt++
                var j = nums[i]
                while (!vis[j]) {
                    vis[j] = true
                    cnt++
                    j = nums[j]
                }
            }
            if (nums[k] != k) cnt -= 2
            return cnt
        }

        return minOf(f(nums, 0), f(arr, n - 1))
    }

}
class Solution2638 {
    fun countTheNumOfKFreeSubsets(nums: IntArray, k: Int): Long {
        nums.sort()
        val g = mutableMapOf<Int, MutableList<Int>>()
        for (i in nums.indices)
            g.computeIfAbsent(nums[i] % k) { mutableListOf() }.add(nums[i])

        var res = 1L
        for (arr in g.values) {
            val m = arr.size
            val f = LongArray(m + 1).also { it[0]=1;it[1]=2 }
            for (i in 2..m)
                f[i] = if (arr[i - 1] - arr[i - 2] == k)  f[i - 1] + f[i - 2] else f[i - 1] * 2
            res *= f[m]
        }
        return res
    }

}
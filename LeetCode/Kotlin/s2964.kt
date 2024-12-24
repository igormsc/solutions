class Solution2964 {
    fun divisibleTripletCount(nums: IntArray, d: Int): Int {
        val cnt = mutableMapOf<Int, Int>()
        val n = nums.size
        var res = 0
        for (j in 0..<n) {
            for (k in j + 1..<n) {
                val x = (d - (nums[j] + nums[k]) % d) % d
                res += cnt[x] ?: 0
            }
            cnt.merge(nums[j] % d, 1) { a: Int, b: Int -> a + b }
        }
        return res
    }

}
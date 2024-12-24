class Solution2461 {
    fun maximumSubarraySum(nums: IntArray, k: Int): Long {
        val cnt = IntArray(100_001)
        var sum = 0L
        var res = 0L
        var unq = 0
        nums.indices.forEach { i ->
            sum += nums[i].toLong()
            cnt[nums[i]]++
            val r = cnt[nums[i]]
            if (r == 1) unq++
            else if (r==2) unq--
            if (i>=k) {
                sum -= nums[i-k].toLong()
                cnt[nums[i-k]]--
                val r = cnt[nums[i-k]]
                if (r==1) unq++
                else if (r==0) unq--
            }
            if (unq ==k) res = maxOf(res,sum)
        }
        return res
    }
}

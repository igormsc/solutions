class Solution523 {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val m = mutableMapOf(0 to -1)
        var cur = 0
        return nums.withIndex().find { (i, n) ->
            cur += n
            if (k != 0) cur %= k
            if (m.contains(cur)) (i - m[cur]!! > 1) else false.also { m[cur] = i }
        } != null
    }
}


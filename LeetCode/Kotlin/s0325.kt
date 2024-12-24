class Solution325 {
    fun maxSubArrayLen(nums: IntArray, k: Int): Int {
        var s = 0L
        var res = 0
        val d = mutableMapOf(0L to -1)
        for (i in nums.indices) {
            s += nums[i].toLong()
            res = maxOf(res, i - (d[s - k]?:i))
            d.putIfAbsent(s, i)
        }
        return res
    }

}
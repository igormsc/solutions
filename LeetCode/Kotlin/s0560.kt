class Solution560 {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val ps = mutableMapOf(0 to 1)
        var (sum, res) = 0 to 0
        nums.forEach{ n ->
            sum += n
            if (ps.contains(sum-k)) res += ps[sum-k]!!
            ps[sum] = (ps[sum]?:0) + 1
        }
        return res
    }
}

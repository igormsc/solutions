class Solution525 {
    fun findMaxLength(nums: IntArray): Int {
        val m = mutableMapOf(0 to -1)
        var res = 0
        var sum = 0
        nums.forEachIndexed { i, n ->
            if (n==0) sum-- else sum++
            if (m.contains(sum)) res = maxOf(i-m[sum]!!, res) else m[sum] = i
        }
        return res
    }
}

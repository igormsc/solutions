class Solution3282 {
    fun findMaximumScore(nums: List<Int>): Long {
        var mx = 0
        return nums.sumOf { n -> mx.toLong().also{mx = maxOf(mx, n)} }
    }
}
class Solution3397 {
    fun maxDistinctElements(nums: IntArray, k: Int): Int {
        val s = mutableSetOf<Int>()
        var p = Int.MIN_VALUE
        nums.sort()
        nums.forEach { n -> maxOf(n-k, p+1).also{ m -> if (m<=n+k) s.add(m).also{p=m} } }
        return s.size
    }
}
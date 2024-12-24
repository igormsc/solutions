class Solution3117 {
    fun minimumValueSum(nums: IntArray, andValues: IntArray): Int {
        val MX = 1_000_000
        val cache = mutableMapOf<Triple<Int, Int, Int>, Int>()
        val (m, n) = nums.size to andValues.size
        fun f(t : Triple<Int,Int,Int>): Int =
            if (cache.containsKey(t)) cache[t]!!
            else {
                val v =
                    when {
                        t.first == m && t.second == n -> 0
                        t.first == m || t.second == n -> MX
                        else -> {
                            val mask = t.third.and(nums[t.first])
                            when {
                                mask < andValues[t.second] -> MX
                                mask == andValues[t.second] -> minOf(f(Triple(t.first + 1, t.second, mask)), nums[t.first] + f(Triple(t.first + 1, t.second + 1, -1)))
                                else -> f(Triple(t.first + 1, t.second, mask))
                            }
                        }
                    }
                cache[t] = v
                v
            }
        return f(Triple(0, 0, -1)).let { if (it == MX) -1 else it }
    }
}

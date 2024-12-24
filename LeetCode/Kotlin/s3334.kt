class Solution3334 {
    fun maxScore(nums: IntArray): Long {
        if (nums.size == 1) return (nums[0] * nums[0]).toLong()
        val (a1, a2) = LongArray(nums.size) to LongArray(nums.size)
        a2[nums.size - 1] = nums[nums.size - 1].toLong()
        a1[nums.size - 1] = a2[nums.size - 1]

        for (i in nums.size - 2 downTo 0) {
            a1[i] = gcd(a1[i + 1], nums[i].toLong())
            a2[i] = a2[i + 1] * nums[i] / gcd(a2[i + 1], nums[i].toLong())
        }
        var a = maxOf(a1[0] * a2[0], a1[1] * a2[1])

        var (x, y) = nums[0].toLong() to nums[0].toLong()
        for (i in 1..<nums.lastIndex) {
            a = maxOf(a,gcd(x, a1[i + 1]) * (y * a2[i + 1]) / gcd(y, a2[i + 1]))
            x = gcd(x, nums[i].toLong())
            y = y * nums[i] / gcd(y, nums[i].toLong())
        }
        return maxOf(a, x * y)
    }

    private fun gcd(a: Long, b: Long): Long = if (b % a == 0L) a else gcd(b % a, a)

}
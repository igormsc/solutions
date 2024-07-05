class Solution3079 {
    fun sumOfEncryptedInt(nums: IntArray): Int =
        nums.sumOf { n ->
            var m = 0
            var d = 0
            var n = n
            while (n > 0) {
                m = m * 10 + 1
                d = maxOf(d, n % 10)
                n /= 10
            }
            d * m
        }
}


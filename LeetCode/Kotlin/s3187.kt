class Solution3187 {
    fun countOfPeaks(nums: IntArray, queries: Array<IntArray>): List<Int> {
        val n = 100_000
        val bt = IntArray(n + 1)
        val res = mutableListOf<Int>()

        fun ps(i: Int): Int {
            var sum = 0
            var i = i + 1
            while (i > 0) {
                sum += bt[i]
                i -= i.and(-i)
            }
            return sum
        }

        fun add(i: Int, v: Int) {
            var i = i + 1
            while (i <= n) {
                bt[i] += v
                i += i.and(-i)
            }
        }

        fun isPeak(i: Int): Boolean = i in 1..<nums.lastIndex && nums[i - 1] < nums[i] && nums[i] > nums[i + 1]
        (1..<nums.lastIndex).forEach { i -> if (isPeak(i)) add(i, 1) }
        queries.forEach { q ->
            if (q[0] == 1) res.add(if (q[1] < q[2]) ps(q[2] - 1) - ps(q[1]) else 0)
            else {
                val i = q[1]
                val prev = booleanArrayOf(isPeak(i - 1), isPeak(i), isPeak(i + 1))
                nums[i] = q[2]
                (0..2).forEach { p -> if (prev[p] != isPeak(i + p - 1)) add(i + p - 1, if (prev[p]) -1 else 1) }
            }
        }
        return res
    }
}
class Solution2198 {
    fun singleDivisorTriplet(nums: IntArray): Long {
        val cnt = IntArray(101)
        nums.forEach { cnt[it]++ }
        var res = 0L
        for (a in 1..100)
            for (b in 1..100)
                for (c in 1..100) {
                    val s = a + b + c
                    val x = cnt[a]
                    val y = cnt[b]
                    val z = cnt[c]
                    var t = 0
                    if (s % a == 0) t++
                    if (s % b == 0) t++
                    if (s % c == 0) t++
                    if (t == 1)
                        res += when {
                            a == b -> 1L * x * (x - 1) * z
                            a == c -> 1L * x * (x - 1) * y
                            b == c -> 1L * x * y * (y - 1)
                            else -> 1L * x * y * z
                        }

                }
        return res
    }

}
class Solution3139 {
    fun minCostToEqualizeArray(nums: IntArray, cost1: Int, cost2: Int): Int {
        val MOD = 1_000_000_007
        val sz = nums.size.toLong()
        val cost1 = cost1.toLong()
        val cost2 = cost2.toLong()
        var max = nums[0]
        var min = nums[0]
        var total = 0L
        nums.forEach { n ->
            min = minOf(min, n)
            max = maxOf(max, n)
            total += n.toLong()
        }
        total = max.toLong() * sz - total
        return (if (2 * cost1 <= cost2 || sz <= 2L) ((total * cost1) % MOD)
                else {
                    var op1 = maxOf(0L, (max - min).toLong() * 2L - total)
                    var op2 = total - op1
                    var res = (op1 + op2 % 2) * cost1 + op2 / 2 * cost2

                    total += op1 / (sz - 2) * sz
                    op1 %= (sz - 2)
                    op2 = total - op1
                    res = minOf(res, (op1 + op2 % 2) * cost1 + op2 / 2 * cost2)

                    repeat(2) {
                        total += sz
                        res = minOf(res, (total % 2 * cost1 + total / 2 * cost2))
                    }
                    (res % MOD)
                }).toInt()
    }
}

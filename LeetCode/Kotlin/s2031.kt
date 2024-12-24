class Solution2031 {
    fun subarraysWithMoreZerosThanOnes(nums: IntArray): Int {
        val mod = 1_000_000_007
        val n = nums.size
        val base = n + 1
        val tr = BinaryIndexedTree(n + base)
        tr.update(base, 1)
        var res = 0
        var s = 0
        for (x in nums) {
            s += if (x == 0) -1 else 1
            res += tr.query(s - 1 + base)
            res %= mod
            tr.update(s + base, 1)
        }
        return res
    }

    internal class BinaryIndexedTree(private val n: Int) {
        private val c = IntArray(n + 1)

        fun update(x: Int, v: Int) {
            var x = x
            while (x <= n) {
                c[x] += v
                x += x and -x
            }
        }

        fun query(x: Int): Int {
            var x = x
            var s = 0
            while (x > 0) {
                s += c[x]
                x -= x and -x
            }
            return s
        }
    }

}
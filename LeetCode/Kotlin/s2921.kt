class Solution2921 {
    fun maxProfit(prices: IntArray, profits: IntArray): Int {
            val n = prices.size
            val left = IntArray(n)
            val right = IntArray(n)
            val m = prices.max()
            val tree1 = BinaryIndexedTree(m + 1)
            val tree2 = BinaryIndexedTree(m + 1)
            for (i in 0..<n) {
                val x = prices[i]
                left[i] = tree1.query(x - 1)
                tree1.update(x, profits[i])
            }
            for (i in n - 1 downTo 0) {
                val x = m + 1 - prices[i]
                right[i] = tree2.query(x - 1)
                tree2.update(x, profits[i])
            }

            var res = -1
            for (i in 0..<n)
                if (left[i] > 0 && right[i] > 0) res = maxOf(res, left[i] + profits[i] + right[i])
            return res
        }

    internal class BinaryIndexedTree(private val n: Int) {
        private val c = IntArray(n + 1)

        fun update(x: Int, v: Int) {
            var x = x
            while (x <= n) {
                c[x] = maxOf(c[x], v)
                x += x and -x
            }
        }

        fun query(x: Int): Int {
            var x = x
            var mx = 0
            while (x > 0) {
                mx = maxOf(mx, c[x])
                x -= x and -x
            }
            return mx
        }
    }

}
class Solution3109 {
    fun getPermutationIndex(perm: IntArray): Int {
        val mod = 1_000_000_007L
        var res = 0L
        val n = perm.size
        val tree = BinaryIndexedTree(n + 1)
        val f = LongArray(n).also{it[0]=1}
        for (i in 1..<n)
            f[i] = f[i - 1] * i % mod
        for (i in 0..<n) {
            val cnt = perm[i] - 1 - tree.query(perm[i])
            res = (res + cnt * f[n - i - 1] % mod) % mod
            tree.update(perm[i], 1)
        }
        return res.toInt()
    }

    internal class BinaryIndexedTree(private val n: Int) {
        private val c = IntArray(n + 1)

        fun update(x: Int, delta: Int) {
            var x = x
            while (x <= n) {
                c[x] += delta
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
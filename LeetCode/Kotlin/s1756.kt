class MRUQueue(n: Int) {
    private var n = n
    private val q = IntArray(n + 2024) { it }.also { it[0] = 0 }
    private val tree = BinaryIndexedTree(n + 2024)

    fun fetch(k: Int): Int {
        var (l, r) = 1 to n
        while (l < r) {
            val mid = (l + r) / 2
            if (mid - tree.query(mid) >= k) r = mid
            else l = mid + 1
        }
        val x = q[l]
        q[++n] = x
        tree.update(l, 1)
        return x
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
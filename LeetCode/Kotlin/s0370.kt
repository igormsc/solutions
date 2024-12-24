class Solution370 {
    fun getModifiedArray(length: Int, updates: Array<IntArray>): IntArray {
        val tree = BinaryIndexedTree(length)
        for (e in updates) {
            val (start, end, inc) = e
            tree.update(start + 1, inc)
            tree.update(end + 2, -inc)
        }
        return (0..<length).fold(IntArray(length)) { r, i -> r[i] = tree.query(i + 1); r }
    }

    internal class BinaryIndexedTree(private val n: Int) {
        private val c = IntArray(n + 1)

        fun update(x: Int, delta: Int) {
            var x = x
            while (x <= n)
                c[x] += delta.also{ x += lowbit(x) }
        }

        fun query(x: Int): Int {
            var x = x
            var s = 0
            while (x > 0)
                s += c[x].also { x -= lowbit(x) }
            return s
        }

        private fun lowbit(x: Int): Int = x.and(-x)
    }


}
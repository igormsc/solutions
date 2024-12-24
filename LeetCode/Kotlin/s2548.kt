class Solution2548 {
    fun maxPrice(items: Array<IntArray>, capacity: Int): Double {
        var capacity = capacity
        items.sortWith{ a: IntArray, b: IntArray -> a[1] * b[0] - a[0] * b[1] }

        var res = 0.0
        for (e in items) {
            val (p, w) = e
            val v = minOf(w, capacity)
            res += v * 1.0 / w * p
            capacity -= v
        }
        return if (capacity > 0) -1.0 else res
    }

}
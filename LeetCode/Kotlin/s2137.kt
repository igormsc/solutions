class Solution2137 {
    fun equalizeWater(buckets: IntArray, loss: Int): Double {
        fun chk(loss: Int, v: Double): Boolean {
            var (a, b) = 0.0 to 0.0
            for (x in buckets)
                if (x > v) a += x - v else b += (v - x) * 100 / (100 - loss)
            return a >= b
        }

        var (l, r) = 0.0 to buckets.max().toDouble()
        while (r - l > 1e-5) {
            val m = (l + r) / 2
            if (chk(loss, m)) l = m else r = m
        }
        return l
    }

}
class Solution1215 {
    fun countSteppingNumbers(low: Int, high: Int): List<Int> {
        val res = mutableListOf<Int>()
        if (low == 0) res.add(0)
        val q = mutableListOf<Long>()
        (1L..9L).forEach{ q.add(it) }
        while (q.isNotEmpty()) {
            val v = q.removeFirst()
            if (v > high) break
            if (v >= low) res.add(v.toInt())
            val x = v.toInt() % 10
            if (x > 0) q.add(v * 10 + x - 1)
            if (x < 9) q.add(v * 10 + x + 1)
        }
        return res
    }

}
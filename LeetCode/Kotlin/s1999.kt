class Solution1999 {
    fun findInteger(k: Int, digit1: Int, digit2: Int): Int {
        if (digit1 == 0 && digit2 == 0) return -1
        if (digit1 > digit2) return findInteger(k, digit2, digit1)

        val k = k.toLong()
        val q = mutableListOf(0L)
        while (true) {
            val x = q.removeFirst()
            if (x > Int.MAX_VALUE.toLong()) return -1
            if (x > k && x % k == 0L) return x.toInt()
            q.add(x * 10 + digit1)
            if (digit1 != digit2) q.add(x * 10 + digit2)
        }
    }

}
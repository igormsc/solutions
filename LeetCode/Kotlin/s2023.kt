class Solution2023 {
    fun findPattern(stream: InfiniteStream, pattern: IntArray): Int {
        var (a, b) = 0L to 0L
        val m = pattern.size
        val half = m.shr(1)
        val mask1 = (1L shl half) - 1
        val mask2 = (1L shl (m - half)) - 1
        for (i in 0..<half)
            a = a or (pattern[i].toLong().shl(half - 1 - i))
        for (i in half..<m)
            b = b or (pattern[i].toLong().shl(m - 1 - i))
        var (x, y) = 0L to 0L
        var i = 1
        while (true) {
            var v = stream.next()
            y = y shl 1 or v.toLong()
            v = ((y shr (m - half)) and 1L).toInt()
            y = y and mask2
            x = x shl 1 or v.toLong()
            x = x and mask1
            if (i >= m && a == x && b == y) return i - m
            i++
        }
    }

    abstract class InfiniteStream {
        abstract fun next(): Int
    }

}
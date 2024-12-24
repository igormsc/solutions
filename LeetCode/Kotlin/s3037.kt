class Solution3037 {
    fun findPattern(stream: InfiniteStream, pattern: IntArray): Int {
            val m = pattern.size
            val p = IntArray(m + 1)
            val np = IntArray(m + 1)
            for (i in 1..m) p[i] = pattern[i - 1]
            run {
                var (i, j) = 2 to 0
                while (i <= m) {
                    while (j > 0 && p[i] != p[j + 1]) j = np[j]
                    if (p[i] == p[j + 1]) j++
                    np[i] = j
                    i++
                }
            }
            var res: Int
            var (i, j) = 1 to 0
            while (true) {
                val x: Int = stream.next()
                while (j > 0 && x != p[j + 1]) j = np[j]
                if (x == p[j + 1]) j++
                if (j == m) {
                    res = i - m
                    break
                }
                i++
            }
            return res
        }
}

abstract class InfiniteStream(bits: IntArray) {
         abstract fun next(): Int
}

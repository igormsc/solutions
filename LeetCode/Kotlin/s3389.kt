class Solution3389 {
    fun makeStringGood(s: String): Int =
        s.fold(IntArray('z'.code + 1)) { r, c -> r[c.code]++; r }.slice('a'.code..'z'.code).let { cnt ->
            (1..s.length).minOf { j ->
                cnt.fold(IntArray(3)) { r, c ->
                    if (c >= j) intArrayOf(minOf(r[0], r[1]) + c - j, s.length, c - j)
                    else intArrayOf(minOf(r[0], r[1]) + c, minOf(r[0] + maxOf(0, j - c - r[2]), r[1] + j - c), c)
                }.dropLast(1).min()
            }
        }
}

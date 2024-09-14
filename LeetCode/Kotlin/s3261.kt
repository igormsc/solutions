class Solution3261 {
    fun countKConstraintSubstrings(s: String, k: Int, queries: Array<IntArray>): LongArray {
        val n = s.length
        val (ac, pre) = LongArray(n) to LongArray(n+1)
        var (l, zero, once) = intArrayOf(0,0,0)
        (0..<n).forEach { r ->
            if (s[r] == '1') once++ else zero++
            while (once > k && zero > k) {if (s[l] == '1') once-- else zero--; l++}
            ac[r] = (r-l+1).toLong()
        }
        (0..<n).forEach { pre[it+1] = pre[it] + ac[it] }
        val res = queries.map{ (l,r) ->
            var cur = 0L
            var ln = 0
            for (i in l..r) {
                ln++
                if (ac[i] <= ln) {cur += pre[r+1] - pre[i]; break}
                else cur += ln
            }
            cur
        }
        return res.toLongArray()
    }
}
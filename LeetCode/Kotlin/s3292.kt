class Solution3292 {
    fun minValidStrings(words: Array<String>, target: String): Int {
        val ps = IntArray(target.length + 1)
        words.forEach { w ->
            val p = f("$w#$target")
            (1..target.length).forEach { ps[it] = maxOf(ps[it], p[w.length + it]) }
        }
        var l = target.length
        var res = 0
        while (l > 0 && ps[l] > 0) l -= ps[l].also { res++ }
        return if (l == 0) res else -1
    }

    private fun f(s: String): IntArray =
        (1..s.lastIndex).fold(IntArray(s.length)) { r, i ->
            var j = r[i - 1]
            while (j > 0 && s[i] != s[j]) j = r[j - 1]
            if (s[i] == s[j]) j++
            r[i] = j
            r }

}

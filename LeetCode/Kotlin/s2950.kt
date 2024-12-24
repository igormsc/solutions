class Solution2950 {
    fun countDivisibleSubstrings(word: String): Int {
        val d = arrayOf("ab", "cde", "fgh", "ijk", "lmn", "opq", "rst", "uvw", "xyz")
        val mp = IntArray(255)
        for (i in d.indices)
            for (c in d[i].toCharArray())
                mp[c.code] = i + 1

        var res = 0
        val cs = word.toCharArray()
        for (i in 1..9) {
            val cnt = mutableMapOf(0 to 1)
            var s = 0
            for (c in cs) {
                s += mp[c.code] - i
                res += cnt[s]?:0
                cnt.merge(s, 1) { a: Int, b: Int -> a+b }
            }
        }
        return res
    }

}
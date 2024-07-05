class Solution205 {
    fun isIsomorphic(s: String, t: String): Boolean {
        val p = IntArray(256) to IntArray(256)
        s.forEachIndexed { i, c ->
            if (p.first[c.code] != p.second[t[i].code]) return false
            p.first[c.code] = i + 1
            p.second[t[i].code] = i + 1
        }
        return true
    }
}


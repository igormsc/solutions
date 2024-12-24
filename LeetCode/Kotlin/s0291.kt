class Solution291 {

    fun wordPatternMatch(pattern: String, s: String): Boolean {
        val vis = mutableSetOf<String>()
        val d = mutableMapOf<Char, String>()
        val m = pattern.length
        val n = s.length

        fun dfs(i: Int, j: Int): Boolean {
            if (i == m && j == n) return true
            if (i == m || j == n || m - i > n - j) return false
            val c = pattern[i]
            for (k in j + 1..n) {
                val t = s.substring(j, k)
                if ( (d[c]?:"") == t && dfs(i + 1, k)) return true
                if (!d.containsKey(c) && !vis.contains(t)) {
                    d[c] = t
                    vis.add(t)
                    if (dfs(i + 1, k)) return true
                    vis.remove(t)
                    d.remove(c)
                }
            }
            return false
        }

        return dfs(0, 0)
    }

}
class Solution1088 {
    fun confusingNumberII(n: Int): Int {
        val d = intArrayOf(0, 1, -1, -1, -1, -1, 9, -1, 8, 6)
        var s = n.toString()

        fun check(x: Int): Boolean {
            var y = 0
            var t = x
            while (t > 0) {
                val v = t % 10
                y = y * 10 + d[v]
                t /= 10
            }
            return x != y
        }

        fun dfs(pos: Int, limit: Int, x: Int): Int {
            if (pos >= s.length) return if (check(x)) 1 else 0
            val up = if (limit == 1) s[pos].code - '0'.code else 9
            var res = 0
            for (i in 0..up)
                if (d[i] != -1) res += dfs(pos + 1, if (limit == 1 && i == up) 1 else 0, x * 10 + i)

            return res
        }

        return dfs(0, 1, 0)
    }

}
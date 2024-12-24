class Solution3327 {
    fun findAnswer(parent: IntArray, s: String): BooleanArray {
        val n = s.length
        var cnt = 0
        val res = BooleanArray(n)
        val ch = Array(n) { mutableListOf<Int>() }
        (1..parent.lastIndex).forEach { i -> ch[parent[i]].add(i) }
        val subs = Array(n) { 0 to 0 }
        val trv = CharArray(2*n+1) {'#'}

        fun dfs(i: Int ) {
            val l = cnt
            ch[i].forEach { dfs(it) }
            trv[2*cnt+1] = s[i]
            subs[i] = l to cnt++
        }

        dfs(0)

        fun manacher(): List<Int> {
            val st = trv.joinToString("","$","^")
            val p = IntArray(st.length)
            var (l,r) = 1 to 1
            (1..st.lastIndex-2).forEach { i ->
                p[i] = maxOf(0, minOf(r-i, p[l+r-i]))
                while (st[i-p[i]] == st[i+p[i]]) p[i]++
                if (p[i]+i > r) { l = i - p[i]; r = i + p[i] }
            }
            return p.slice(1..<p.lastIndex)
        }

        val d = manacher()
        (0..s.lastIndex).forEach { i ->
            val (l, r) = subs[i]
            res[i] = d[l+r+1] - 1 >= r-l+1
        }
        return res
    }
}

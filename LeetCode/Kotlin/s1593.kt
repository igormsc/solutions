class Solution1593 {
    fun maxUniqueSplit(s: String): Int {
        var res = 0
        val st = mutableSetOf<String>()

        fun dfs(i: Int) {
            res = maxOf(st.size, res)
            if (i >= s.length) return
            val chs = mutableListOf<Char>()
            (i..s.lastIndex).forEach { i ->
                chs.add(s[i])
                val str = chs.joinToString("")
                if (!st.contains(str)) {
                    st.add(str)
                    dfs(i + 1)
                    st.remove(str)
                }
            }
        }
        dfs(0)
        return res
    }
}


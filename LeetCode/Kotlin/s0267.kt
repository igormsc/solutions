class Solution267 {
    fun generatePalindromes(s: String): List<String> {
        val res = mutableListOf<String>()
        val cnt = IntArray('z'.code+1)

        for (c in s.toCharArray()) cnt[c.code]++
        var mid = ""
        for (i in 'a'.code..'z'.code) {
            if (cnt[i] % 2 == 1) {
                if (mid != "") return res
                mid = i.toChar().toString()
            }
        }

        fun dfs(t: String) {
            if (t.length == s.length) {
                res.add(t)
                return
            }
            for (i in 'a'.code..'z'.code) {
                if (cnt[i] > 1) {
                    val c = i.toChar().toString()
                    cnt[i] -= 2
                    dfs(c + t + c)
                    cnt[i] += 2
                }
            }
        }

        dfs(mid)
        return res
    }

}
class Solution014 {
    fun longestCommonPrefix(strs: Array<String>): String {
        val n = strs.size
        if (n == 0) return ""
        val res = StringBuilder()
        strs.sort()
        val (a,b) = strs[0] to strs.last()
        for (i in a.indices)
            if (a[i] == b[i]) res.append(a[i]) else break
        return res.toString()
    }
}

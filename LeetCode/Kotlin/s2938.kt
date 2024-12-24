class Solution2938 {
    fun minimumSteps(s: String): Long {
        var j = 0
        var res = 0L
        for (i in s.indices)
            if (s[i] == '0') res += (i - j++).toLong()
        return res
    }
}

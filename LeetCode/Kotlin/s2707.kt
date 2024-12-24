class Solution2707 {
    fun minExtraChar(s: String, dictionary: Array<String>): Int {
        val dp = IntArray(51) {-1}

        fun f (i: Int): Int =
            if (i==s.length) 0 else {
                if (dp[i]==-1) {
                    dp[i] = 1+f(i+1)
                    dictionary.forEach { w ->
                        if (i+w.length<=s.length && s.substring(i..i+w.lastIndex)==w)
                            dp[i] = minOf(dp[i],f(i+w.length))
                    }
                }
                dp[i]
            }

        return f(0)
    }

}


class Solution3333 {
    fun possibleStringCount(word: String, k: Int): Int {
        val MOD = 1_000_000_007L
        val v = mutableListOf<Int>()
        var p = 1L
        var cnt = 1
        (1..word.length).forEach { i ->
            if (i<word.length && word[i-1] == word[i]) cnt++
            else {
                v.add(cnt-1)
                p = (p*cnt.toLong())%MOD
                cnt = 1
            }
        }
        if (k<=v.size) return p.toInt()
        val dp = Array(2) {IntArray(2001) }
        dp[0][0] = 1
        val ps = IntArray(2001)
        val sz = v.size
        for (i in v.indices)
            for (q in 0..<k-v.size) {
                ps[q+1] = (ps[q] + dp[i%2][q]) % MOD.toInt()
                dp[if (i%2==0) 1 else 0][q] = (ps[q+1]-ps[maxOf(q-v[i],0)])%MOD.toInt()
            }
        return ((MOD + p - dp[sz%2].slice(0..k).sumOf{ it.toLong() } % MOD) %MOD) .toInt()
    }
}

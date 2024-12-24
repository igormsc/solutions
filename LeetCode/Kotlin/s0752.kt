class Solution752 {
    fun openLock(deadends: Array<String>, target: String): Int {
        val dp = BooleanArray(10_000)
        deadends.forEach { dp[it.toInt()] = true }
        if (dp[0]) return -1
        val t = target.toInt()
        var res = 0
        var q = mutableListOf(0)
        while (q.isNotEmpty()) {
           var q1 = mutableListOf<Int>()
           q.forEach { dd ->
               if (dd==t) return res
               var p = 1
               while (p < 10_000) {
                   val d = dd / p % 10
                   (-1..1 step 2).forEach { dir ->
                       val ndd = dd - d*p + (10+d+dir)%10*p
                       if (!dp[ndd]) dp[ndd] = true.also { q1.add(ndd) }
                   }
                   p *=10
               }
           }
            res++
            q = q1.also { q1 = q }
        }
        return -1
    }
}

class Solution1434 {
    fun numberWays(hats: List<List<Int>>): Int {
        val mod = 1_000_000_007
        val dp = Array(40) { mutableListOf<Int>() }
        val n = hats.size
        val msk = IntArray(1.shl(n)).also{it[0]=1}
        hats.indices.forEach { i -> hats[i].forEach { dp[it-1].add(i) } }
        dp.indices.forEach { i ->
            (1.shl(n)-1 downTo 0).forEach { j ->
                dp[i].forEach { p -> if (j.and(1.shl(p)) == 0) msk[j.or(1.shl(p))] = (msk[j.or(1.shl(p))] + msk[j])%mod } } }
        return msk.last()
    }
}

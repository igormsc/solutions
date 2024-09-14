class Solution3186 {
    fun maximumTotalDamage(power: IntArray): Long {
        val dp = LongArray(power.size+1)
        var mx = 0L
        power.sort()
        var j = 0
        power.indices.forEach{ i ->
            if (power[i] == power[maxOf(0, i-1)]) dp[i+1] = dp[i] + power[i].toLong()
            else {
                while (power[j]<power[i]-2) mx = maxOf(mx, dp[++j])
                dp[i+1] = mx + power[i].toLong()
            }
        }
        return dp.max()
    }
}
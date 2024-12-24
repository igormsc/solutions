class Solution3287 {
    fun maxValue(nums: IntArray, k: Int): Int {
        val n = nums.size
        val dp = Array(n) { Array(k + 2) { BooleanArray(1 shl 7 + 1) } }.also { it[0][1][nums[0]] = true }

        for (i in 1..<n) {
            dp[i][1][nums[i]] = true
            for (j in 1..128)
                for (a in 1..k)
                    if (dp[i - 1][a][j]) {
                        dp[i][a + 1][j or nums[i]] = true
                        dp[i][a][j] = true
                    }
        }


        val dp2 = Array(n) { Array(k + 2) { BooleanArray(1 shl 7 + 1) } }.also { it[n - 1][1][nums[n - 1]] = true}

        for (i in n - 2 downTo 0) {
            dp2[i][1][nums[i]] = true
            for (j in 1..128)
                for (a in 1..k)
                    if (dp2[i + 1][a][j]) {
                        dp2[i][a + 1][j or nums[i]] = true
                        dp2[i][a][j] = true
                    }
        }

        var res = 0
        for (i in 0..<n)
            if (i + 1 >= k && n - (i + 1) >= k)
                for (a in 1..128)
                    for (b in 1..128)
                        if (dp[i][k][a] && dp2[i + 1][k][b]) res = maxOf(res, a xor b)
        return res
    }


}

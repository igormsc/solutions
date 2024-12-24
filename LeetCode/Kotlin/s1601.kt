class Solution1601 {
    fun maximumRequests(n: Int, requests: Array<IntArray>): Int {
        val dp = IntArray(n+1)

        fun fs(i: Int): Int =
            if (i==requests.size) dp.slice(0..<n).count{it==0}.let {if (it==n) 0 else Int.MIN_VALUE}
            else {
                dp[requests[i][0]]--
                dp[requests[i][1]]++
                val t = fs(i+1) + 1
                dp[requests[i][0]]++
                dp[requests[i][1]]--
                maxOf(fs(i+1), t)
            }

        return fs(0)
    }
}

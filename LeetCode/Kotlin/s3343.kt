import java.math.BigInteger

class Solution3343 {
    fun countBalancedPermutations(num: String): Int {
        val n = num.length
        var sum = 0
        val nums = IntArray(n)
        val hash = IntArray(10)
        for (i in 0..<n) {
            nums[i] = num[i].code - '0'.code
            hash[nums[i]]++
            sum += nums[i]
        }
        if ((sum and 1) == 1) return 0
        var ind = 0
        for (i in 9 downTo 0) {
            var cnt = hash[i]
            while (cnt-- > 0) nums[ind++] = i
        }

        var duplicates = BigInteger.ONE
        for (i in 0..9) if (hash[i] > 1) duplicates = duplicates.multiply(factorial(hash[i]))
        val target = sum / 2
        val odd = (n + 1) / 2
        val even = n / 2
        val dp = Array(odd + 1) { Array(even + 1) { arrayOfNulls<BigInteger>(361) } }
        return f(odd, even, target, n, nums, dp)!!.divide(duplicates).mod(BigInteger.valueOf(1000000007)).toInt()
    }

    private fun factorial(n: Int): BigInteger {
        var n = n
        var fact = BigInteger.ONE
        while (n > 1) {
            fact = fact.multiply(BigInteger.valueOf(n.toLong()))
            n--
        }
        return fact
    }

    private fun f(odd: Int, even: Int, target: Int, n: Int, nums: IntArray, dp: Array<Array<Array<BigInteger?>>>): BigInteger? {
        if (target < 0) return BigInteger.ZERO
        if (odd == 0 && even == 0) {
            if (target == 0) return BigInteger.ONE
            return BigInteger.ZERO
        }
        if (dp[odd][even][target] != null) return dp[odd][even][target]
        var ways = BigInteger.ZERO
        if (odd > 0) ways = ways.add(f(odd - 1, even, target - nums[n - (odd + even)], n, nums, dp)!!.multiply(BigInteger.valueOf(odd.toLong())))
        if (even > 0) ways = ways.add(f(odd, even - 1, target, n, nums, dp)!!.multiply(BigInteger.valueOf(even.toLong())))
        return ways.also { dp[odd][even][target] = it }
    }
}

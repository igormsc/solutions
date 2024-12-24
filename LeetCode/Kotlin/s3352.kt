class Solution3352 {

    val MOD = 1000000007L

    var factorial = LongArray(805)
    var invFactorial= LongArray(805)

    init {
        factorial[0] = 1
        invFactorial[0] = 1
        for (i in 1..800) factorial[i] = (factorial[i - 1] * i) % MOD
        invFactorial[800] = modPow(factorial[800], MOD - 2, MOD)
        for (i in 799 downTo 1) invFactorial[i] = (invFactorial[i + 1] * (i + 1)) % MOD
    }

    fun countKReducibleNumbers(s: String, k: Int): Int {
        val length = s.length

        val reductionSteps = LongArray(801) {-1}
        reductionSteps[1] = 0
        for (i in 2..800) {
            val setBits = Integer.bitCount(i)
            reductionSteps[i] = reductionSteps[setBits] + 1
        }

        var res = 0L

        for (i in 1..length) {
            var vl = i.toLong()
            if (reductionSteps[i] <= k - 1) {
                for (j in 0..<length) {
                    if (s[j.toInt()] == '1') {
                        val remainingBits = (length - j - 1).toLong()
                        if (remainingBits < vl - 1) break
                        if (remainingBits >= vl) res = (res + binomial(remainingBits, vl)) % MOD
                        vl--
                        if (vl <= 0) {
                            res++
                            res %= MOD
                            break
                        }
                    }
                }
            }
        }

        var totalSetBits = 0
        for (i in 0..<length)
            if (s[i] == '1') totalSetBits++

        if (reductionSteps[totalSetBits] <= k - 1) res--
        res =  (res + MOD) % MOD

        return res.toInt()
    }

    fun modPow(base: Long, exp: Long, mod: Long): Long {
        var base = base
        var exp = exp
        var result: Long = 1
        base %= mod
        while (exp > 0) {
            if ((exp and 1L) == 1L) result = (result * base) % mod
            exp = exp shr 1
            base = (base * base) % mod
        }
        return result
    }

    fun binomial(n: Long, k: Long): Long {
        if (n < k) return 0
        return ((factorial[n.toInt()] * invFactorial[(n - k).toInt()] % MOD) * invFactorial[k.toInt()]) % MOD
    }
}

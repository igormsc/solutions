import java.math.BigInteger

class Solution3339 {

    val MOD = 1_000_000_007L

    var factorial = LongArray(805)
    var invFactorial= LongArray(805)

    init {
        factorial[0] = 1
        invFactorial[0] = 1
        for (i in 1..800) factorial[i] = (factorial[i - 1] * i) % MOD
        invFactorial[800] = modPow(factorial[800], MOD - 2, MOD)
        for (i in 799 downTo 1) invFactorial[i] = (invFactorial[i + 1] * (i + 1)) % MOD
    }

    fun countOfArrays(n: Int, m: Int, k: Int): Int {
        var (o,e) = ((m+1)/2).toLong() to (m/2).toLong()
        var res = 0L
        if (k==0) res += BigInteger.valueOf(o).modPow(BigInteger.valueOf(n.toLong()), BigInteger.valueOf(MOD)).toLong()
        (1..(n+1-k)/2+1).forEach { x ->
            res += BigInteger.valueOf(binomial(x+k-1, x-1)).multiply(BigInteger.valueOf(binomial(n-x-k+1,x)).multiply(
                BigInteger.valueOf(e).modPow(BigInteger.valueOf((x+k).toLong()), BigInteger.valueOf(MOD))).multiply(
                BigInteger.valueOf(o).modPow(BigInteger.valueOf((n-x-k).toLong()), BigInteger.valueOf(MOD))).mod(BigInteger.valueOf(MOD))).toLong() % MOD

        }
        return (res % MOD).toInt()
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

    fun binomial(n: Int, k: Int): Long {
        if (n < k) return 0
        return (((factorial[n] * invFactorial[(n - k)] % MOD) * invFactorial[k]) % MOD).toLong()
    }


}
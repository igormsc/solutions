import java.math.BigInteger

class Solution3179 {
    fun valueAfterKSeconds(n: Int, k: Int): Int =
            (0..<minOf(k,n-1)).fold(BigInteger.ONE) { r, i ->
                r.multiply(BigInteger.valueOf((n+k-1-i).toLong())).divide(BigInteger.valueOf((i+1).toLong()))
            }.mod(BigInteger.valueOf(1_000_000_007L)).toInt()

}

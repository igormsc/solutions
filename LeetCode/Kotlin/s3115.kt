class Solution3115 {

    val primes = sieve(101)

    private fun sieve(n:Int): BooleanArray {
        val primes = BooleanArray(n+1){true}.also { it[0] = false; it[1] = false }
        var i = 2
        while (i*i<=n) {
            if (primes[i]) (i*i..n step i).forEach { primes[it] = false }
            i++
        }
        return primes
    }

    fun maximumPrimeDifference(nums: IntArray): Int {
        val n = nums.size
        var res = 0
        var first = -1
        var j = 0
        while (j<n) {
            if (primes[nums[j]]) if (first != -1) res = j-first else first = j
            j++
        }
        return res
    }

}

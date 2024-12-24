class Solution2601 {

    private val isPrime = BooleanArray(1005) { true }
    private val prime = mutableListOf<Int>()

    private fun seive(n: Int) {
        isPrime[0] = false
        isPrime[1] = false
        var i = 2
        while (i * i < n) {
            (2 * i..<n step i).forEach { isPrime[it] = false }
            i++
        }
    }

    init {
        seive(1005)
        (0..1003).forEach { i -> if (isPrime[i]) prime.add(i) }
    }

    fun primeSubOperation(nums: IntArray): Boolean {
        val n = nums.size
        var flg = false
        var prev = nums.last()
        for (i in n - 2 downTo 0)
            if (nums[i] < prev) prev = nums[i]
            else {
                flg = true
                var j = 0
                while (j < prime.size && prime[j] < nums[i]) {
                    if (nums[i] - prime[j] < prev) {
                        prev = nums[i] - prime[j]
                        flg = false
                        break
                    }
                    j++
                }
                if (flg) break
            }
        return !flg
    }

}


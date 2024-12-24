class Solution3326 {

    private val isPrime = BooleanArray(1005) { true }
    private val prime = mutableListOf<Int>()
    private val dp = IntArray(1_000_001)

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

    fun minOperations(nums: IntArray): Int {

        var res = 0
        for (i in nums.lastIndex-1 downTo 0) {
            if (nums[i] > nums[i+1]) {
                res++
                if (dp[nums[i]]==0) {
                    dp[nums[i]] = nums[i]
                    var j = 0
                    while (prime[j]*prime[j] <= nums[i]) {
                        if (nums[i]%prime[j]==0) {
                            dp[nums[i]]= prime[j]
                            break
                        }
                        j++
                    }
                }
                nums[i] = dp[nums[i]]
                if (nums[i] > nums[i+1]) return -1
            }
        }
        return res
    }

}

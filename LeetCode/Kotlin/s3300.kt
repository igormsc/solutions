class Solution3300 {
    fun minElement(nums: IntArray): Int =
        nums.minOf { n ->
            var (a,b) = 0 to n
            while (b>0) a += b%10 .also{b /=10}
            a }

}

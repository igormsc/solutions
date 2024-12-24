class Solution3318 {
    fun findXSum(nums: IntArray, k: Int, x: Int): IntArray {
        val n = nums.size
        val res = IntArray(n - k + 1)
        val freq = Array(51) { IntArray(2) }
        (0..50).forEach{ freq[it][0] = it }
        (0..<k).forEach { freq[nums[it]][1]++ }

        fun sum(x: Int): Int {
            freq.sortWith { a: IntArray, b: IntArray -> if (a[1] == b[1]) b[0] - a[0] else b[1] - a[1] }
            val sum = (0..<x).sumOf{ freq[it][0] * freq[it][1] }
            freq.sortWith {a: IntArray, b: IntArray -> a[0] - b[0] }
            return sum
        }

        res[0] = sum(x)
        var (i, j) = 1 to k
        while (j < n) {
            freq[nums[i - 1]][1]--
            freq[nums[j]][1]++
            res[i] = sum(x)
            i++
            j++
        }
        return res
    }
}

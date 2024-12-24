class Solution1228 {
    fun missingNumber(arr: IntArray): Int {
        val n = arr.size
        val d = (arr.last() - arr.first()) / n
        for (i in 1..<n)
            if (arr[i] != arr[i - 1] + d) return arr[i - 1] + d
        return arr[0]
    }

}

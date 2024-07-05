fun main() {

    val sl = Solution3095()

    val nums = intArrayOf(1,12,2,5)
    val k = 43
    println(sl.minimumSubarrayLength(nums, k))

}


class Solution3095 {
    fun minimumSubarrayLength(nums: IntArray, k: Int): Int {
        var arr = nums
        (1..nums.size+1).forEach { i ->
            if (arr.isNotEmpty() && arr.max() >= k) return i
            arr = arr.zip(nums.slice(i..nums.lastIndex)).map{ it.first or it.second }.toIntArray()
        }
        return -1
    }
}

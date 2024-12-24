class Solution1636 {
    fun frequencySort(nums: IntArray): IntArray {
        val cnt = nums.fold(mutableMapOf<Int,Int>()) { m, n -> m[n] = (m[n]?: 0) + 1; m}
        return nums.sortedWith(compareBy<Int> { cnt[it]?:0 }.thenBy { -it }).toIntArray()
    }
}

fun main() {
    val nums = intArrayOf(-1,1,-6,4,5,-6,1,4,1)
    val sl = Solution1636()
    println(sl.frequencySort(nums).joinToString(" "))
    println("[5,-1,4,4,-6,-6,1,1,1]")
}

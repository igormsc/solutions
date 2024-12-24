class Solution3151 {
    fun isArraySpecial(nums: IntArray): Boolean =
        (nums.size == 1) || nums.toList().windowed(2, 1).find { it.first().and(1) == it.last().and(1) } == null

}

fun main() {
    val sl = Solution3151()
    val a = intArrayOf(2,1,4)
    println(sl.isArraySpecial(a))
}

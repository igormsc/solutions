class Solution3232 {
    fun canAliceWin(nums: IntArray): Boolean = nums.sumOf { if (it<10) it else -it } != 0
}

class Solution1822 {
    fun arraySign(nums: IntArray): Int = nums.fold(1) { r, n -> if (n==0) 0 else if (n < 0) -r else r }

}

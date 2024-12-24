class Solution1085 {
    fun sumOfDigits(nums: IntArray): Int {
        var x = nums.min()
        var s = 0
        while (x > 0) {
            s += x % 10
            x /= 10
        }
        return s.and(1).xor(1)
    }

}
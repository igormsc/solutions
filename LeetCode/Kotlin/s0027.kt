class Solution027 {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var k = 0
        for (n in nums)
            if (n != `val`) nums[k++] = n
        return k
    }
}
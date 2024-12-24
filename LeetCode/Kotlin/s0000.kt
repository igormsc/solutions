class Solution000 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val mp =  mutableMapOf<Int, Int>()
        var i = 0
        while (true) {
            val n = nums[i]
            val add = target - n
            if (mp.containsKey(add)) return intArrayOf(mp[add]!!, i)
            mp[n] = i++
        }
    }
}
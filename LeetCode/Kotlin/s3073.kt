import java.util.*

class Solution3073 {
    fun maximumTripletValue(nums: IntArray): Int {
        val n = nums.size
        val right = IntArray(n)
        right[n - 1] = nums[n - 1]
        for (i in n - 2 downTo 0)
            right[i] = maxOf(nums[i], right[i + 1])

        val ts = TreeSet<Int>()
        ts.add(nums[0])
        var res = 0
        for (j in 1..<n - 1) {
            if (right[j + 1] > nums[j]) {
                val l = ts.lower(nums[j])
                if (l != null) res = maxOf(res, l - nums[j] + right[j + 1])
            }
            ts.add(nums[j])
        }
        return res
    }

}
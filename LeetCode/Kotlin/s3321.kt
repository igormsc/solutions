
import java.util.*

class Solution3321 {
    fun findXSum(nums: IntArray, k: Int, x: Int): LongArray {
        var sum = 0L
        val res = LongArray(nums.size - k + 1)
        val l = TreeSet { a: LongArray, b: LongArray -> if (a[0] == b[0]) a[1].compareTo(b[1]) else a[0].compareTo(b[0]) }
        val r = TreeSet { a: LongArray, b: LongArray -> if (a[0] == b[0]) b[1].compareTo(a[1]) else b[0].compareTo(a[0]) }
        val m = mutableMapOf<Int, LongArray>()
        for (i in nums.indices) {
            if (l.contains(m[nums[i]]?:LongArray(2))) {
                l.remove(m[nums[i]])
                sum -= nums[i] * m[nums[i]]!![0]
            }
            r.remove(m[nums[i]]?:LongArray(2))
            m[nums[i]] = longArrayOf((m[nums[i]]?:LongArray(1))[0] + 1, nums[i].toLong())
            r.add(m[nums[i]])
            if (i >= k - 1) {
                while (l.size < x && r.isNotEmpty()) {
                    sum += r.first()!![0] * r.first()!![1]
                    l.add(r.pollFirst())
                }
                res[i - k + 1] = sum
                if (l.contains(m[nums[i - k + 1]]?:LongArray(2))) {
                    l.remove(m[nums[i - k + 1]])
                    sum -= nums[i - k + 1] * m[nums[i - k + 1]]!![0]
                }
                r.remove(m[nums[i - k + 1]]?:LongArray(2))
                m[nums[i - k + 1]] = longArrayOf((m[nums[i - k + 1]]?:LongArray(1))[0] - 1, nums[i - k + 1].toLong())
                r.add(m[nums[i - k + 1]])
                if (l.isNotEmpty()) {
                    sum -= l.first()!![0] * l.first()!![1]
                    r.add(l.pollFirst())
                }
            }
        }
        return res
    }
}

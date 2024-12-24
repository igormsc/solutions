
class Solution3164 {
    fun numberOfPairs(nums1: IntArray, nums2: IntArray, k: Int): Long {
        val mx = nums1.max()
        val cnt = nums2.fold(mutableMapOf<Int,Int>()) { r, n -> (n*k).also{ if (it <= mx) r[it] = (r[it]?:0) + 1};  r}
        val mlt = LongArray(mx+1)
        cnt.forEach { (f, c) ->
            var x = f
            while (x <= mx) {
                mlt[x] += c.toLong()
                x += f
            }
        }
        return nums1.sumOf{ mlt[it] }
    }

}


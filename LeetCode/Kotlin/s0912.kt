class Solution912 {
    fun sortArray(nums: IntArray): IntArray {

        fun merge(l: Int, m: Int, h: Int) {
            var left = l
            var right = m + 1
            val buffer = IntArray(h - l + 1)

            var k = 0
            while (left <= m && right <= h) {
                if (nums[left] <= nums[right]) {
                    buffer[k++] = nums[left++]
                } else {
                    buffer[k++] = nums[right++]
                }
            }
            while (left <= m) buffer[k++] = nums[left++]
            while (right <= h) buffer[k++] = nums[right++]

            for (i in l..h) {
                nums[i] = buffer[i - l]
            }
        }

        fun sort(l: Int, h: Int) {
            if (h - l + 1 <= 1) return
            val mid = l + (h - l) / 2
            sort(l, mid)
            sort(mid + 1, h)
            merge(l, mid, h)
        }

        sort(0, nums.lastIndex)
        return nums
    }

}

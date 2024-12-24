class Solution1150 {
    fun isMajorityElement(nums: IntArray, target: Int): Boolean {
            val n = nums.size

            fun search(x: Int): Int {
                var (l, r) = 0 to nums.size
                while (l < r) {
                    val mid = (l + r)/2
                    if (nums[mid] >= x) r = mid
                    else l = mid + 1
                }
                return l
            }

            val r  = search(target) + n/2
            return r < n && nums[r] == target
        }

}
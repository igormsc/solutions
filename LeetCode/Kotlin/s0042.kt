class Solution042 {
    fun trap(height: IntArray): Int =
        sequence {
            var (l, r) = 0 to height.lastIndex
            var x = 0
            while (l < r) {
                val low = if (height[l] < height[r]) height[l++] else height[r--]
                if (x < low) x = low
                yield(x - low)
            }
        }.sum()
}
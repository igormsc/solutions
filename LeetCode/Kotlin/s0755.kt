class Solution755 {
    fun pourWater(heights: IntArray, volume: Int, k: Int): IntArray {
        repeat (volume) {
            var d = -1
            var flg = false
            while (d < 2 && !flg) {
                var (i, j) = k to k
                while (i + d in heights.indices && heights[i + d] <= heights[i]) {
                    if (heights[i + d] < heights[i]) j = i + d
                    i += d
                }
                if (j != k) {
                    flg = true
                    heights[j]++
                }
                d += 2
            }
            if (!flg) heights[k]++
        }
        return heights
    }

}
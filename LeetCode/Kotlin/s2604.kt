class Solution2604 {
    fun minimumTime(hens: IntArray, grains: IntArray): Int {
        hens.sort()
        grains.sort()
        var (l, r) = 0 to  1500000000
        while (l < r) {
            val mid = l + (r - l) / 2
            var i = 0
            for (h in hens) {
                val z = i
                while (i < grains.size && (grains[i] <= h && h - grains[i] <= mid || h <= grains[z] && grains[i] - h <= mid ||
                            grains[z] <= h && h <= grains[i] && grains[i] - grains[z] + minOf(grains[i] - h, h - grains[z]) <= mid)) i++

            }
            if (i == grains.size) r = mid
            else l = mid + 1
        }
        return l
    }
}
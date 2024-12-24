class Solution3388 {
    fun beautifulSplits(nums: IntArray): Int {
        val n = nums.size
        val lcps = Array(n) { IntArray(n) }
        lcps.indices.forEach { j ->
            var (mxI, mxR) = j to j
            (j+1..<n).forEach { i ->
                if (mxR >= i) lcps[j][i] = minOf(mxR-i+1, lcps[j][i-mxI+j])
                while (i + lcps[j][i] < n && nums[i+lcps[j][i]] == nums[lcps[j][i]+j]) lcps[j][i]++
                if (i+lcps[j][i]-1>mxR) mxI = i.also{ mxR = i + lcps[j][i] -1 }
            }
        }
        return (0..n).sumOf { i ->
                    (i+1..<n-1).count { (lcps[0][i+1] >= i+1 && it-i >= i+1) || lcps[i+1][it+1] >= it-i } }
    }
}

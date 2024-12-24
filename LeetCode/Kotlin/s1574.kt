class Solution1574 {
    fun findLengthOfShortestSubarray(arr: IntArray): Int {
        var (l, r) = 0 to arr.lastIndex
        while (r>0 && arr[r-1] <= arr[r]) r--
        var res = r
        while (l < r && (l == 0 || arr[l-1] <= arr[l])) {
            while (r < arr.size && arr[r] < arr[l]) r++
            res = minOf(res, r-l-1)
            l++
        }
        return res
    }
}


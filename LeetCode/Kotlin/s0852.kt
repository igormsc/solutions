class Solution852 {
    fun peakIndexInMountainArray(arr: IntArray): Int {
        var (l, r) = 0 to arr.lastIndex
        while (l < r) {
            val m = (l+r)/2
            if (arr[m]<arr[m+1]) l = m+1 else r = m
        }
        return l
    }

}

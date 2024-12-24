class Solution1306 {
    fun canReach(arr: IntArray, start: Int): Boolean =
        if (start in arr.indices && arr[start] >= 0 ) {
            arr[start] = -arr[start]
            arr[start] == 0 || canReach(arr, start+arr[start]) || canReach(arr, start-arr[start])
        } else false
}

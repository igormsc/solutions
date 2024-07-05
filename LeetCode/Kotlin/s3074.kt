class Solution3074 {
    fun minimumBoxes(apple: IntArray, capacity: IntArray): Int {
        capacity.sortDescending()
        var s = apple.sum()
        var i = 0
        while (i<capacity.size && s > 0) s -=capacity[i++]
        return i
    }
}

class Solution1287 {
    fun findSpecialInteger(arr: IntArray): Int {
        val size = arr.size
        return intArrayOf(arr[size/4], arr[size/2], arr[size*3/4])
            .find { num -> arr.lastIndexOf(num)  - arr.indexOf(num) >= size/4 }?: -1
    }
}
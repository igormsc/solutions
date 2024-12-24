class Solution1213 {
    fun arraysIntersection(arr1: IntArray, arr2: IntArray, arr3: IntArray): List<Int> =
        arr1.fold(mutableListOf()) { r, x ->
            (arr2.binarySearch(x) to arr3.binarySearch(x)).also { if (it.first >= 0 && it.second >= 0) r.add(x) }; r}

}
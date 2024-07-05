class Solution1122 {
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        val cnt = arr1.fold(IntArray(1001)) { r, n -> r[n]++; r}
        var i = -1
        arr2.forEach { n ->
            while (cnt[n] > 0) {
                i++
                arr1[i] = n
                cnt[n]--
            }
        }
        cnt.indices.forEach { j ->
            while (cnt[j]>0) {
                i++
                arr1[i] = j
                cnt[j]--
        }
        }
        return arr1
    }
}

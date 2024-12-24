class Solution1331 {
    fun arrayRankTransform(arr: IntArray): IntArray {
        var rank = 1
        val m = mutableMapOf<Int,Int>()
        for (r in arr.sortedArray()) if (!m.contains(r)) m[r] = rank++
        for (i in arr.indices) arr[i] = m[arr[i]]!!
        return arr
    }
}
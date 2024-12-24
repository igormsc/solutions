class Solution769 {
    fun maxChunksToSorted(arr: IntArray): Int {
        var mx = 0
        return arr.indices.count { i -> maxOf(mx, arr[i]).also{mx=it} == i }
    }
}

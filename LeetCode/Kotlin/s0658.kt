class Solution658 {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        val i =
            generateSequence(Pair(0, arr.size-k)) {
                val m = (it.first+it.second) / 2
                if (x-arr[m] > arr[m+k]-x) Pair(m+1, it.second) else Pair(it.first, m)
            }
                .find{it.first >= it.second}!!.first

        return arr
            .slice(i..<i+k)
    }
}
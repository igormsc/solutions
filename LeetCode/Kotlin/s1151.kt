class Solution1151 {
    fun minSwaps(data: IntArray): Int {
        val k = data.sum()
        var t = (0..<k).sumOf{ data[it] }

        return k - (k..data.lastIndex).fold(t){ r, i ->
                        t += data[i] - data[i - k]
                        maxOf(r,t) }
    }

}

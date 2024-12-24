class Solution1868 {
    fun findRLEArray(encoded1: Array<IntArray>, encoded2: Array<IntArray>): List<List<Int>> {
        var j = 0
        val res = mutableListOf<MutableList<Int>>()
        for (e in encoded1) {
            val a = e[0]
            var b = e[1]
            while (b > 0) {
                val f = minOf(b, encoded2[j][1])
                val v = a * encoded2[j][0]
                val m = res.size
                if (m > 0 && res[m - 1][0] == v) res[m - 1][1] = res[m - 1][1] + f
                else res.add(mutableListOf(v, f))
                b -= f
                encoded2[j][1] -= f
                if (encoded2[j][1] == 0) j++
            }
        }
        return res
    }

}
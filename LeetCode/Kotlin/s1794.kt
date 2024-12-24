class Solution1794 {
    fun countQuadruples(firstString: String, secondString: String): Int {
        val last = IntArray(255)
        secondString.indices.forEach { last[secondString[it].code] = it + 1 }
        var res = 0
        var mn = Int.MAX_VALUE/2
        firstString.indices.forEach { i ->
            val j = last[firstString[i].code]
            if (j > 0) {
                val t = i - j
                if (mn > t) {
                    mn = t
                    res = 1
                } else if (mn == t) res++
            }
        }
        return res
    }

}
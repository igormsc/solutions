class Solution246 {
    fun isStrobogrammatic(num: String): Boolean {
        val d = intArrayOf(0, 1, -1, -1, -1, -1, 9, -1, 8, 6)
        var (i, j) = 0 to num.lastIndex
        while (i <= j)
            if (d[num[i++].code - '0'.code] != num[j--].code - '0'.code) return false
        return true

    }
}
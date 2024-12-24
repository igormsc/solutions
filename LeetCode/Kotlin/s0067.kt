class Solution067 {
    fun addBinary(a: String, b: String): String {
        var (i, j, c) = intArrayOf(a.lastIndex, b.lastIndex, 0)
        return buildString {
            while (i >= 0 || j >= 0 || c > 0) {
                c += (if (i >= 0) a[i].code - '0'.code else 0) + (if (j >= 0) b[j].code - '0'.code else 0)
                append(c % 2)
                c /= 2
                --i
                --j
            }
        }.reversed()
    }
}
class Solution3216 {
    fun getSmallestString(s: String): String {
        val b = s.toCharArray()
        for (i in 0..<b.lastIndex) {
            if (b[i].code%2 == b[i+1].code%2 && b[i]>b[i+1] ) {
                b[i] = b[i+1].also { b[i+1] = b[i] }
                break
            }
        }
        return b.joinToString("")
    }
}

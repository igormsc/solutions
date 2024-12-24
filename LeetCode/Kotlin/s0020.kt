class Solution020 {
    fun isValid(s: String): Boolean {
        var i = 0
        val b = s.toCharArray()
        b.forEach { c ->
            if (i>0 && (c.code - b[i-1].code+1)/2 == 1) i--
            else b[i++] = c
        }
        return i == 0
    }
}

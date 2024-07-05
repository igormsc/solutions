class Solution1404 {
    fun numSteps(s: String): Int {
        var c: Byte = 0;
        return (s.lastIndex downTo 1).fold(0) { r, i ->
            r + if (s[i].code - '0'.code + c == 1) 2.also { c = 1 } else 1
        } + c.toInt()
    }
}

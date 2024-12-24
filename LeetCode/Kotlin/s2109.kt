class Solution2109 {
    fun addSpaces(s: String, spaces: IntArray): String = buildString {
        var j = 0
        s.forEachIndexed { i, c ->
            if (j<spaces.size && spaces[j] == i) append(' ').also {j++}
            append(c) }
    }
}

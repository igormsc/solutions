class Solution1190 {
    fun reverseParentheses(s: String): String {
        val n = s.length
        val opened = mutableListOf<Int>()
        val pair = IntArray(n)
        s.forEachIndexed { i, c ->
            if (c == '(') opened.add(i)
            if (c == ')') {
                val j = opened.removeLast()
                pair[i] = j
                pair[j] = i
            }
        }
        val sb = StringBuilder()
        var d = 1
        var i = 0
        while (i<n) {
            if (s[i] == '(' || s[i] == ')' ) {
                i = pair[i]
                d = -d
            } else sb.append(s[i])
            i += d
        }
        return sb.toString()
    }

}

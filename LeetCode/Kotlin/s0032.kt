class Solution032 {
    fun longestValidParentheses(s: String): Int {
        var res = 0
        val stk = mutableListOf(-1)
        s.indices.forEach { i ->
            if (s[i] == '(') stk.add(i)
            else {
                if (stk.isNotEmpty()) stk.removeLast()
                if (stk.isNotEmpty()) res = maxOf(res, i - stk.last()) else stk.add(i)
            }
        }
        return res
    }
}

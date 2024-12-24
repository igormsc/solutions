class Solution439 {
    fun parseTernary(expression: String): String {
        val stk = mutableListOf<Char>()
        var flg = false
        for (i in expression.lastIndex downTo 0) {
            val c = expression[i]
            if (c == ':') continue
            if (c == '?') flg = true
            else {
                if (flg) {
                    if (c == 'T') {
                        val x = stk.removeLast()
                        stk.removeLast()
                        stk.add(x)
                    } else stk.removeLast()
                    flg = false
                } else stk.add(c)
            }
        }
        return stk.last().toString()
    }

}
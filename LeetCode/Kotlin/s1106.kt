class Solution1106 {
    fun parseBoolExpr(expression: String): Boolean {
        val s = mutableListOf<Char>()
        expression.forEach { ch ->
            if (ch == ')') {
                var hasT = false
                var hasF = false
                while (s.last() == 't' || s.last() == 'f') {
                    val l = s.removeLast()
                    hasT = hasT || l == 't'
                    hasF = hasF || l == 'f'
                }
                val op = s.removeLast()
                s.add(
                    when (op) {
                        '!' -> if (hasF) 't' else 'f'
                        '&' -> if (!hasF) 't' else 'f'
                        else -> if (hasT) 't' else 'f'
                    }
                )
            } else if (ch != ',' && ch != '(') s.add(ch)
        }
        return s.last() == 't'
    }

}

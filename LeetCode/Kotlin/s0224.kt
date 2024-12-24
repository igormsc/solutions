class Solution224 {
    fun calculate(s: String, i: Int): Pair<Int, Int> {
        var i = i
        var num = 0
        val stack = mutableListOf<Int>()
        var sign = "+"

        fun update(op: String, v: Int) {
            when (op) {
                "+" -> stack.add(v)
                "-" -> stack.add(-v)
                "*" -> stack.add(stack.removeLast() * v)
                "/" -> stack.add(stack.removeLast() / v)
            }
        }

        while (i < s.length) {
            when {
                s[i].isDigit() -> num = num * 10 + s[i].code - '0'.code
                s[i] in "+-*/" -> {
                    update(sign, num)
                    num = 0
                    sign = s[i].toString()
                }

                s[i] == '(' -> {
                    val c = calculate(s, i + 1)
                    num = c.first
                    i = c.second - 1
                }

                s[i] == ')' -> {
                    update(sign, num)
                    return stack.sum() to i + 1
                }
            }
            i++
        }
        update(sign, num)
        return stack.sum() to i
    }
}

fun main() {
    val sl = Solution224()

    var s = "(1+(4+5+2)1-3)+(6+8)"
    println(sl.calculate(s, 0))
}

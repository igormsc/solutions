class Solution772 {
    fun calculate(s: String): Int = clc(s.filter { it != ' '}.toMutableList().also{it.add('+')})

    private fun clc(tks: MutableList<Char>): Int {
        var (num, sum, prev) = intArrayOf(0,0,0)
        var prevOp = '+'

        while (tks.isNotEmpty()) {
            val t = tks.removeFirst()
            if (t in '0'..'9') num = num * 10 + t.code - '0'.code
            else if (t == '(') num = clc(tks)
            else {
                when (prevOp) {
                    '+' -> {
                        sum += prev
                        prev = num
                    }
                    '-' -> {
                        sum += prev
                        prev = -num
                    }
                    '*' -> prev *= num
                    '/' -> prev /= num
                }
                if (t == ')') break
                prevOp = t
                num = 0
            }
        }
        return sum + prev
    }
}
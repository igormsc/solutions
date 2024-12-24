class Solution682 {
    fun calPoints(operations: Array<String>): Int {
        val stk = mutableListOf<Int>()
        return operations.sumOf { o ->
            when (o) {
                "C" -> -stk.removeLast()
                "D" -> (stk.last()*2).also{stk.add(it)}
                "+" -> (stk[stk.lastIndex-1] + stk.last()).also{stk.add(it)}
                else -> o.toInt().also{stk.add(it)}
            }
        }
    }
}

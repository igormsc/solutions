class Solution241 {
    fun diffWaysToCompute(expression: String): List<Int> {
        val mp = mutableMapOf<String,MutableList<Int>>()

        fun f(exp: String): MutableList<Int> {
            val res = mutableListOf<Int>()
            exp.forEachIndexed { i, e ->
                if (e in charArrayOf('+', '-', '*')) {
                    val sb1 = exp.slice(0..<i)
                    val r1 = if (mp.containsKey(sb1)) mp[sb1]!! else f(sb1)
                    val sb2 = exp.slice(i+1..exp.lastIndex)
                    val r2 = if (mp.containsKey(sb2)) mp[sb2]!! else f(sb2)
                    for (n1 in r1)
                        for (n2 in r2)
                            when (e) {
                                '+' -> res.add(n1 + n2)
                                '-' -> res.add(n1 - n2)
                                else -> res.add(n1 * n2)
                            }
                }
            }
            if (res.isEmpty()) res.add(exp.toInt())
            mp[exp] = res
            return res
        }

        return f(expression)
    }
}

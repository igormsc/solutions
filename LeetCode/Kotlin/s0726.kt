class Solution726 {
    fun countOfAtoms(formula: String): String {
        val recordFrontBracket = mutableListOf<Int>()
        val len = formula.length
        val atoms = mutableListOf<String>()
        val counts = mutableListOf<Int>()
        var i = 0
        while (i < len) {
            val c = formula[i]
            when {
                c == '(' -> recordFrontBracket.add(atoms.size)
                c == ')' -> {
                    var number = 0
                    while (i+1<len && formula[i+1].isDigit() ) number = number*10 + formula[i+1].digitToInt() .also {i++}
                    if (number == 0 ) number = 1
                    val index = recordFrontBracket.removeLast()!!
                    (index..counts.lastIndex).forEach { counts[it] *= number }
                }
                c.isUpperCase() -> {
                    var t = i
                    while (t+1<len && formula[t+1].isLowerCase()) t++
                    atoms.add(formula.substring(i, t + 1))
                    i = t
                    var count = 0
                    while (i+1<len && formula[i+1].isDigit()) count = count*10 + formula[i+1].digitToInt() .also {i++}
                    if (count == 0) count = 1
                    counts.add(count)
                }
            }
            i++
        }

        val mp = mutableMapOf<String,Int>().toSortedMap()
        atoms.forEachIndexed { q, atom -> mp[atom] = (mp[atom] ?: 0) + counts[q]  }
        val sb = StringBuilder()
        mp.forEach { (k, v) ->
                sb.append(k)
                if (v!=1) sb.append(v.toString())
            }
        return sb.toString()
    }
}

fun main() {
    val sl = Solution726()

    var formula = "K4(ON(SO3)2)2"
    println(sl.countOfAtoms(formula))
}

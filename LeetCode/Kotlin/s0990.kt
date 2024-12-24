class Solution990 {
    fun equationsPossible(equations: Array<String>): Boolean {
        val uf = IntArray(26) {it}
        fun find(x: Int): Int = if (x != uf[x]) find(uf[x]).also{uf[x]=it} else uf[x]
        equations.forEach { if (it[1] == '=') uf[find(it[0].code - 'a'.code)] = find(it[3].code - 'a'.code) }
        return !equations.any { it[1] == '!' && uf[find(it[0].code - 'a'.code)] == find(it[3].code - 'a'.code) }
    }
}

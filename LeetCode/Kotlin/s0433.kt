class Solution433 {
    fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
        val q = mutableListOf(startGene)
        val vis = mutableSetOf(startGene)
        var depth = 0
        while (q.isNotEmpty()) {
            for (m in q.size downTo 1) {
                val gene = q.removeFirst()
                if (gene == endGene) return depth
                for (b in bank) {
                    var (c, k) = 2 to 0
                    while (k < 8 && c > 0)
                        if (gene[k] != b[k++]) c--
                    if (c > 0 && !vis.contains(b))
                        q.add(b).also{ vis.add(b)}
                }
            }
            depth++
        }
        return -1
    }
}

class Solution582 {
    fun killProcess(pid: List<Int>, ppid: List<Int>, kill: Int): List<Int> {
        val g = mutableMapOf<Int, MutableList<Int>>()
        val res = mutableListOf<Int>()

        for (i in pid.indices)
            g.computeIfAbsent(ppid[i]) { mutableListOf() }.add(pid[i])

        fun dfs(i: Int) {
            res.add(i)
            (g[i]?:listOf()).forEach { dfs(it) }
        }

        dfs(kill)
        return res
    }

}
class Solution1376 {
    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {

        fun dfs(u: Int): Int {
            if (manager[u] != -1) {
                informTime[u] += dfs(manager[u])
                manager[u] = -1
            }
            return informTime[u]
        }

        return (0..<n).maxOf { dfs(it) }
    }
}

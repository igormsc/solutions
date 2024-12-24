class Solution364 {
    fun depthSumInverse(nestedList: List<NestedInteger>): Int {
        var s = 0
        var ws = 0
        var maxDepth = 0

        fun dfs(x: NestedInteger, d: Int) {
            maxDepth = maxOf(maxDepth, d)
            if (x.isInteger()) {
                ws += x.getInteger() * d
                s += x.getInteger()
            } else x.getList().forEach{ dfs(it, d + 1)}
        }

        nestedList.forEach{ dfs(it, 1)}
        return (maxDepth + 1) * s - ws
    }

}
class Solution339 {
    fun depthSum(nestedList: List<NestedInteger>): Int = dfs(nestedList, 1)

    private fun dfs(nestedList: List<NestedInteger>, depth: Int): Int =
        nestedList.sumOf { if (it.isInteger()) it.getInteger() * depth else dfs(it.getList(), depth + 1) }

}

    abstract class NestedInteger {
        fun isInteger(): Boolean =true
        fun getInteger(): Int = 0
        fun getList() : List<NestedInteger> = emptyList()
    }

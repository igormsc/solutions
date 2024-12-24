class Solution2782 {
    fun numberOfCategories(n: Int, categoryHandler: CategoryHandler): Int {
        val d = IntArray(n) {it}

        fun find(x: Int): Int {
            if (d[x] != x) d[x] = find(d[x])
            return d[x]
        }

        for (i in 0..<n)
            for (j in i + 1..<n)
                if (categoryHandler.haveSameCategory(i, j)) d[find(i)] = find(j)

        return (0..<n).count{it == d[it]}
    }

    abstract class CategoryHandler {
        abstract fun haveSameCategory(a: Int, b: Int): Boolean
    }

}
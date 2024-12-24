class Solution254 {
    fun getFactors(n: Int): List<List<Int>> {
        val t = mutableListOf<Int>()
        val res = mutableListOf<List<Int>>()

        fun dfs(n: Int, i: Int) {
            if (t.isNotEmpty()) res.add(mutableListOf<Int>().also{ it.addAll(t); it.add(n)})
            var j = i
            while (j <= n/j) {
                if (n % j == 0) {
                    t.add(j)
                    dfs(n / j, j)
                    t.removeLast()
                }
                j++
            }
        }

        dfs(n, 2)
        return res
    }


}
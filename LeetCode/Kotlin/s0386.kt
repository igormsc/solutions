class Solution386 {
    fun lexicalOrder(n: Int): List<Int> {
        val res = mutableListOf<Int>()

        fun dfs(i: Int) {
            (0..9).forEach { j ->
                val num = 10*i+j
                if (num != 0) {
                    if (num>n) return
                    res.add(num)
                    dfs(num)
                }
            }
        }

        dfs(0)
        return res
    }

}

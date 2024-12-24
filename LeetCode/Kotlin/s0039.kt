class Solution039 {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val ln = candidates.size
        val res = mutableListOf<List<Int>>()

        fun dfs(trg: Int, curP: MutableList<Int>, start: Int) {
            if (trg < 0) return
            if (trg == 0) {
                res.add(curP.toList())
                return
            }
            var i = start
            while (i < ln) {
                curP.add(candidates[i])
                dfs(trg-candidates[i], curP, i)
                curP.removeLast()
                i++
            }
        }

        dfs(target, mutableListOf(), 0)
        return res

    }
}

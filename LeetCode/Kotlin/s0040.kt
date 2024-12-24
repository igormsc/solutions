class Solution40 {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        candidates.sort()
        val lcl = mutableListOf<Int>()

        fun find(order: Int, target: Int) {
            if (target == 0) {
                res.add(lcl.toList())
                return
            } else {
                for (i in order..candidates.lastIndex) {
                    if (candidates[i] > target) return
                    if (i > 0 && candidates[i] == candidates[i-1] && i > order) continue
                    lcl.add(candidates[i])
                    find(i+1, target-candidates[i])
                    lcl.removeLast()
                }

            }
        }
        find(0, target)
        return res
    }
}

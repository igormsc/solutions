class Solution3159 {
    fun occurrencesOfElement(nums: IntArray, queries: IntArray, x: Int): IntArray {
        val p = nums.withIndex().filter{ it.value == x }.map{it.index}
        return queries.map{ q -> if (q <= p.size) p[q-1] else -1 }.toIntArray()
    }
}

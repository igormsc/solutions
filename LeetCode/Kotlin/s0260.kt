class Solution260 {
    fun singleNumber(nums: IntArray): IntArray {
        val x = nums.reduce(Int::xor).let { it.and(-it) }
        return nums.fold(IntArray(2)) { r, n ->
                                                    val i = if (n.and(x) == 0) 0 else 1
                                                    r[i] = r[i].xor(n)
                                                    r }
    }
}

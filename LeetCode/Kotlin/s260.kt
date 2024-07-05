class Solution260 {
    fun singleNumber(nums: IntArray): IntArray {
        val x = nums.reduce(Int::xor).let { it.and(-it) }
        return nums.fold(IntArray(2)) { r, n ->
                                                    val i = if (n.and(x) == 0) 0 else 1
                                                    r[i] = r[i].xor(n)
                                                    r }
    }

//    fun singleNumber(nums: IntArray): IntArray =
//        nums.fold(mutableMapOf<Int,Int>()) { r, n -> r[n] = (r[n]?:0) + 1; r}.filter { it.value == 1 }.keys.toIntArray()

}

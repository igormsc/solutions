class Solution1863 {
    fun subsetXORSum(nums: IntArray): Int =
        (1..1.shl(nums.size)).fold(0) { r, i ->
            nums.foldIndexed(0) { j, x, n -> if (i.and(1.shl(j)) != 0) x.xor(n) else x } + r
        }
}

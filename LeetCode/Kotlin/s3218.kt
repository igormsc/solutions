class Solution3218 {
    fun minimumCost(m: Int, n: Int, horizontalCut: IntArray, verticalCut: IntArray): Int =
        horizontalCut.sum() + verticalCut.sum() + horizontalCut.sumOf { h -> verticalCut.sumOf{ v -> minOf(h,v)}}
}

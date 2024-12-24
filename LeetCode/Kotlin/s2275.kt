class Solution2275 {
    fun largestCombination(candidates: IntArray): Int =
        (0..29).maxOf { i -> candidates.count { it.shr(i).and(1) != 0 } }
}


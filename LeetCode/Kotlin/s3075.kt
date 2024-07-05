class Solution3075 {
    fun maximumHappinessSum(happiness: IntArray, k: Int): Long =
        happiness
            .sortedDescending()
            .withIndex()
            .takeWhile { it.value > it.index && k > it.index }
            .sumOf { (it.value - it.index).toLong() }

}

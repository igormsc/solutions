class Solution2214 {
    fun minimumHealth(damage: IntArray, armor: Int): Long =
        damage.sumOf { it.toLong() } - minOf(damage.maxOf { it.toLong() }, armor.toLong()) + 1L
}
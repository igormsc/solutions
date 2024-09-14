class Solution3274 {
    fun checkTwoChessboards(coordinate1: String, coordinate2: String): Boolean = (coordinate1.sumOf{it.code} + coordinate2.sumOf {it.code})%2 == 0
}

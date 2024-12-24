class Solution1823 {
    fun findTheWinner(n: Int, k: Int): Int = (1..n).fold(0) { r, i -> (r+k)%i } + 1
}

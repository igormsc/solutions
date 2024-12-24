class Solution1275 {
    fun tictactoe(moves: Array<IntArray>): String {
        val cnt = IntArray(8)
        val n = moves.size
        var k = n - 1
        while (k >= 0) {
            val (i, j) = moves[k]
            cnt[i]++
            cnt[j + 3]++
            if (i == j) cnt[6]++
            if (i + j == 2) cnt[7]++
            if (cnt[i] == 3 || cnt[j + 3] == 3 || cnt[6] == 3 || cnt[7] == 3) return if (k % 2 == 0) "A" else "B"
            k -= 2
        }
        return if (n == 9) "Draw" else "Pending"
    }
}

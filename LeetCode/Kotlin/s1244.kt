import java.util.*

class Leaderboard() {
    private val d = mutableMapOf<Int, Int>()
    private val rank = TreeMap<Int, Int> { a: Int, b: Int -> b - a }

    fun addScore(playerId: Int, score: Int) {
        d.merge(playerId, score) { a: Int, b: Int -> a + b }
        val newScore = d[playerId]!!
        if (newScore != score)
            rank.merge(newScore - score, -1) { a: Int, b: Int -> a + b }

        rank.merge(newScore, 1) { a: Int, b: Int -> a + b }
    }

    fun top(K: Int): Int {
        var k = K
        var res = 0
        for (e in rank.entries) {
            val score = e.key
            val cnt = minOf(e.value, k)
            res += score * cnt
            k -= cnt
            if (k == 0) break
        }
        return res
    }

    fun reset(playerId: Int) {
        val score = d.remove(playerId)!!
        if (rank.merge(score, -1) { a: Int, b: Int -> a + b } == 0) rank.remove(score)
    }
}
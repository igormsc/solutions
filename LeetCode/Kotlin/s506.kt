import java.util.*

class Solution506 {
    fun findRelativeRanks(score: IntArray): Array<String> {
        val ids = score.foldIndexed(Array(score.size) { 0 to 0 }) { i, r, s -> r[i] = i to s; r }
        Arrays.sort(ids) { a, b -> a.second - b.second }
        return score.indices.fold(Array(score.size) { "" }) { r, i ->
                    when (i) {
                        0 -> r[ids[i].first] = "Gold Medal"
                        1 -> r[ids[i].first] = "Silver Medal"
                        2 -> r[ids[i].first] = "Bronze Medal"
                        else -> r[ids[i].first] = (i + 1).toString()
                    }
                    r
                }
    }
}

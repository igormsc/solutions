import kotlin.math.absoluteValue

class Solution1989 {
    fun catchMaximumAmountofPeople(team: IntArray, dist: Int): Int {
        val n = team.size
        var res = 0
        var j = 0
        team.indices.forEach { i ->
            if (team[i] == 1) {
                while (j < n && (team[j] == 1 || i - j > dist)) j++
                if (j < n && (i - j).absoluteValue <= dist) {
                    res++
                    j++
                }
            }
        }
        return res
    }

}
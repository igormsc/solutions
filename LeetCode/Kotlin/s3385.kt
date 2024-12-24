import kotlin.math.ceil

class Solution3385 {
    fun findMinimumTime(strength: IntArray): Int {
        val n = strength.size
        val weight = Array(n) { IntArray(n) }
        strength.indices.forEach { i ->
            strength.indices.forEach { j ->
                weight[i][j] = ceil(strength[j].toDouble()/(i.toDouble()+1.0)).toInt() } }
        val (ySword, yLock) = IntArray(n) to IntArray(n)
        val (matchLock, matchSword) = IntArray(n) {-1} to IntArray(n) {-1}
        (0..<n).forEach { sword ->
            val (slackMin, slackOwner) = IntArray(n) { Int.MAX_VALUE } to IntArray(n) {-1}
            val (visitedSword, visitedLock) = BooleanArray(n) to BooleanArray(n)
            var z = sword
            while (true) {
                visitedSword[z] = true
                var delta = Int.MAX_VALUE
                var nextLock = -1
                (0..<n).forEach { i ->
                    if (!visitedLock[i]) {
                        val cost = weight[z][i] - ySword[z] - yLock[i]
                        if (cost < slackMin[i]) {
                            slackMin[i] = cost
                            slackOwner[i] = z
                        }
                        if (slackMin[i] < delta) {
                            delta = slackMin[i]
                            nextLock = i
                        }
                    }
                }
                (0..<n).forEach { i ->
                    if (visitedSword[i]) ySword[i] += delta
                    if (visitedLock[i]) yLock[i] -= delta
                    else slackMin[i] -= delta
                }
                var cur = nextLock
                visitedLock[cur] = true
                var s = slackOwner[cur]
                if (matchSword[cur] == -1) {
                    while (cur != -1) {
                        val prevLock = matchLock[s]
                        matchSword[cur] = s
                        matchLock[s] = cur
                        cur = prevLock
                        s = if (cur != -1) slackOwner[cur] else -1
                    }
                    break
                }
                z = matchSword[cur]
            }
        }
        return (0..<n).sumOf { weight[it][matchLock[it]] }
    }
}

class Solution3175 {
    fun findWinningPlayer(skills: IntArray, k: Int): Int {
        var i = 0
        var cur = 0
        for (j in 1..skills.lastIndex) {
            if (skills[i]<skills[j]) cur = 0.also {i=j}
            if (++cur == k) break
        }
        return i
    }
}

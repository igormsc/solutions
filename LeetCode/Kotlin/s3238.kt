class Solution3238 {
    fun winningPlayerCount(n: Int, pick: Array<IntArray>): Int =
        pick.fold(Array(n) {IntArray(11)}) { r, p -> r[p[0]][p[1]]++; r}
            .let { cnt -> cnt.indices.count { i -> cnt[i].find{ it > i} != null } }
}

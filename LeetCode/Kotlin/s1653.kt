class Solution1653 {
    fun minimumDeletions(s: String): Int {
        var cntA = s.count { it == 'a' }
        var cntB = 0
        return s.fold(cntA) { r, c ->
                    if (c == 'a') cntA--
                    if (c == 'b') cntB++
                    minOf(r,cntA+cntB) }

    }
}

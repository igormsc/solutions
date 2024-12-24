class Solution1181 {
    fun beforeAndAfterPuzzles(phrases: Array<String>): List<String> {
        val n = phrases.size
        val ps = Array(n) { arrayOf<String>() }
        for (i in 0..<n) {
            val ws = phrases[i].split(" ").dropLastWhile { it.isEmpty() }
            ps[i] = arrayOf(ws[0], ws.last())
        }
        val s = mutableSetOf<String>()
        for (i in 0..<n)
            for (j in 0..<n)
                if (i != j && ps[i][1] == ps[j][0])
                    s.add(phrases[i] + phrases[j].substring(ps[j][0].length))
        return s.sorted()
    }

}
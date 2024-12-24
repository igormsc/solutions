class Solution293 {
    fun generatePossibleNextMoves(currentState: String): List<String> {
        val s = currentState.toCharArray()
        val res = mutableListOf<String>()
        for (i in 0..<s.lastIndex)
            if (s[i] == '+' && s[i + 1] == '+') {
                s[i] = '-'
                s[i + 1] = '-'
                res.add(String(s))
                s[i] = '+'
                s[i + 1] = '+'
            }
        return res
    }

}
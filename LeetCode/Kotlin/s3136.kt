class Solution3136 {
    fun isValid(word: String): Boolean {
        val n = word.length
        if (n<3) return false
        var v = 0
        var c = 0
        word.forEach { w ->
            if (w.isLetterOrDigit()) {
                if (w in "aeiouAEIOU") v++
                else if (w.isLetter()) c++
            } else return false
        }
        return v >= 1 && c >= 1
    }
}

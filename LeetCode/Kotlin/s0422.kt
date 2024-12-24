class Solution422 {
    fun validWordSquare(words: List<String>): Boolean {
        val m = words.size
        for (i in 0..<m) {
            val n = words[i].length
            for (j in 0..<n) {
                if (j >= m || i >= words[j].length) return false
                if (words[i][j] != words[j][i]) return false
            }
        }
        return true
    }

}
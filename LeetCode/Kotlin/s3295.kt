class Solution3295 {
    fun reportSpam(message: Array<String>, bannedWords: Array<String>): Boolean {
        val s = bannedWords.toSet()
        return message.count { s.contains(it) } > 1
    }
}

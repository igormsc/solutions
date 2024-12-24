class Solution3330 {
    fun possibleStringCount(word: String): Int = (1..word.lastIndex).count { word[it] == word[it-1] }.let{ it+1 }
}

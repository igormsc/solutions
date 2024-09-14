class Solution1684 {
    fun countConsistentStrings(allowed: String, words: Array<String>): Int =
        words.count { allowed.toSet().containsAll(it.toSet()) }
}
class Solution58 {
    fun lengthOfLastWord(s: String): Int = s.trimEnd().takeLastWhile { it != ' ' }.length
    
}
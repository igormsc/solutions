class Solution2490 {
    fun isCircularSentence(sentence: String): Boolean {
        for (i in 1..sentence.lastIndex)
            if (sentence[i] == ' ' && sentence[i-1] != sentence[i+1]) return false
        return sentence[0] == sentence.last()
    }
}

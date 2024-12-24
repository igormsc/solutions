class Solution1813 {
    fun areSentencesSimilar(sentence1: String, sentence2: String): Boolean {
        if (sentence1.length == sentence2.length) return sentence1 == sentence2
        val (s1,s2) = if (sentence2.length < sentence1.length) sentence2 to sentence1 else sentence1 to sentence2
        var ss = -1
        var ls = s1.length
        var d = s2.length - s1.length
        var i = 0
        while (i<s1.length && s1[i] == s2[i]) {
            if (s1[i] == ' ' || s2[i+1] == ' ') ss = i
            i++
        }
        i = s1.lastIndex
        while (i >= maxOf(0,ss) && s1[i] == s2[d+i]) {
            if (s1[i] == ' ' || s2[d+i-1] == ' ') ls = i
            i--
        }
        return ss == s1.lastIndex || ls == 0 || ss == ls
    }
}

class Solution734 {
    fun areSentencesSimilar(sentence1: Array<String>, sentence2: Array<String>, similarPairs: List<List<String>>): Boolean {
        if (sentence1.size != sentence2.size) return false
        val s = mutableSetOf<String>()
        for (e in similarPairs) s.add(e[0] + "." + e[1])

        for (i in sentence1.indices) {
            val (a, b) = sentence1[i] to sentence2[i]
            if (a != b && !s.contains("$a.$b") && !s.contains("$b.$a")) return false
        }
        return true
    }

}
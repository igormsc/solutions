class Solution737 {

    fun areSentencesSimilarTwo(sentence1: Array<String>, sentence2: Array<String>, similarPairs: List<List<String>>): Boolean {
        val mp = mutableMapOf<String?, String?>()

        val n = sentence1.size
        if (sentence2.size != n) return false

        fun find(s: String?): String? {
            var s = s
            while (mp[s] !== s) {
                val p = mp[s]
                mp[s] = mp[p]
                s = mp[s]
            }
            return s
        }

        fun union(s1: String?, s2: String?) {
            var s1 = s1
            var s2 = s2
            s1 = find(s1)
            s2 = find(s2)
            if (s1 == s2) return
            mp[s1] = s2
        }

        for (p in similarPairs) {
            mp.putIfAbsent(p[0], p[0])
            mp.putIfAbsent(p[1], p[1])
            union(p[0], p[1])
        }
        for (i in 0..<n)
            if (sentence1[i] != sentence2[i]) {
                val ss1 = find(sentence1[i])
                val ss2 = find(sentence2[i])
                if (ss1 == null || ss2 == null || ss1 != ss2) return false
            }
        return true
    }

}
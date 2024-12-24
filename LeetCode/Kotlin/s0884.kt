class Solution884 {
    fun uncommonFromSentences(s1: String, s2: String): Array<String> {
        val m = mutableMapOf<String, Int>()
        fun cnt(s: String) = s.split(" ").forEach {m[it] = (m[it]?:0)+1}
        cnt(s1)
        cnt(s2)
        return m.filterValues { it == 1 }.map{it.key}.toTypedArray()
    }
}
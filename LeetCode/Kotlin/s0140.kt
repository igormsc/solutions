fun main() {
    val sl = Solution140()

    val s = "catsanddog"
    val wordDict = listOf("cat","cats","and","sand","dog")

    println(sl.wordBreak(s,wordDict))
    println("""Output: ["cats and dog","cat sand dog"]""")
}


class Solution140 {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val dict = wordDict.toSet()
        val match = s.fold(mutableListOf<MutableSet<String>>()) { r, _ -> r.add(mutableSetOf()); r}
        val temp = mutableListOf<String>()

        val result =  mutableListOf<String>()
        if (wordDict.isEmpty()) return result

        val answer = CharArray(2*s.length+2)

        val maxLen = dict.maxOfOrNull { it.length }?:0
        val minLen = dict.minOfOrNull { it.length }?:0

        fun words(str: String, start: Int) {
            if (start<0) return
            val i = start - minLen + 1
            val j = maxOf(0,(start - maxLen + 1))
            if (i<0) return
            var len = minLen
            (i downTo j).forEach{
                val chunk = str.slice(it..<it+len)
                if (!match[it].contains(chunk) && dict.contains(chunk)) {
                    match[it].add(chunk)
                    words(str, it-1)
                }
                len++
            }
        }
        words(s,  s.lastIndex)

        fun build(str: String, start: Int) {
            if (start == str.length) {
                var j = 0
                temp.forEach {
                    it.indices.forEach { i -> answer[j++] = it[i] }
                    answer[j++] = ' '
                }
                result.add(answer.slice(0..<j-1).joinToString(""))
                return
            }
            match[start].forEach { w ->
                temp.add(w)
                build(str, start+w.length)
                temp.removeLast()
            }
        }
        build(s, 0)
        return result
    }

}

import kotlin.collections.List
import kotlin.collections.indices

class Solution127 {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val words = wordList.toMutableSet()
        val q = mutableListOf(beginWord)
        var res = 1
        while (q.isNotEmpty()) {
            res++
            for (i in q.size downTo 1) {
                val s = q.removeFirst()
                val chars = s.toCharArray()
                for (j in chars.indices) {
                    val ch = chars[j]
                    var k = 'a'
                    while (k <= 'z') {
                        chars[j] = k
                        val t = String(chars)
                        if (!words.contains(t)) k++
                        else {
                            if (endWord == t) return res
                            q.add(t)
                            words.remove(t)
                            k++
                        }
                    }
                    chars[j] = ch
                }
            }
        }
        return 0
    }

}
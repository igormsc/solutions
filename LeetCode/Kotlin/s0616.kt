class Solution616 {
    fun addBoldTag(s: String, words: Array<String>): String {
        val trie = Trie()
        for (w in words) trie.insert(w)
        val pairs = mutableListOf<IntArray>()
        val n = s.length
        for (i in 0..<n) {
            var node: Trie? = trie
            for (j in i..<n) {
                val idx = s[j].code
                if (node!!.children[idx] == null) break
                node = node.children[idx]
                if (node!!.isEnd) pairs.add(intArrayOf(i, j))
            }
        }
        if (pairs.isEmpty()) return s
        val t = mutableListOf<IntArray>()
        var (st, ed) = pairs[0]
        for (j in 1..<pairs.size) {
            val (a, b) = pairs[j]
            if (ed + 1 < a) {
                t.add(intArrayOf(st, ed))
                st = a
                ed = b
            } else ed = maxOf(ed, b)
        }
        t.add(intArrayOf(st, ed))
        var (i, j) = 0 to 0
        val res = StringBuilder()
        while (i < n) {
            if (j == t.size) {
                res.append(s.substring(i))
                break
            }
            st = t[j][0]
            ed = t[j][1]
            if (i < st) res.append(s.substring(i, st))
            j++
            res.append("<b>")
            res.append(s.substring(st, ed + 1))
            res.append("</b>")
            i = ed + 1
        }
        return res.toString()
    }

    internal class Trie {
        var children = Array<Trie?>(128) {null}
        var isEnd: Boolean = false

        fun insert(word: String) {
            var node: Trie? = this
            for (c in word.toCharArray()) {
                if (node!!.children[c.code] == null) node.children[c.code] = Trie()
                node = node.children[c.code]
            }
            node!!.isEnd = true
        }
    }

}

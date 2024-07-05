class Solution648 {
    class Trie {
        private var isRoot = false
        val l = Array<Trie?>(26) {null}

        fun insert(word: String, ch: Int, sz: Int) {
            isRoot = isRoot || ch == sz
            if (!isRoot) {
                if (l[word[ch].code-'a'.code] == null) l[word[ch].code-'a'.code] = Trie()
                l[word[ch].code-'a'.code]!!.insert(word, ch+1, sz)
            }
        }

        fun root(word: String, st: Int, ch: Int, sz: Int): Int {
            if (st+ch == sz || word[st+ch] == ' ' || isRoot) return ch
            if (l[word[st+ch].code-'a'.code] == null) {
                var ch = ch
                while (st+ch < sz && word[st+ch] != ' ') ch++
                return ch
            }
            return l[word[st+ch].code-'a'.code]!!.root(word, st, ch+1, sz)
        }

    }

    fun replaceWords(dictionary: List<String>, sentence: String): String {
        val t = Trie()
        val res = StringBuilder()
        dictionary.forEach { t.insert(it, 0, it.length) }
        var i = 0
        while (i < sentence.length) {
            if (sentence[i] == ' ') res.append(sentence[i++])
            val chs = t.root(sentence, i, 0, sentence.length)
            res.append(sentence.slice(i..<i+chs))
            i += chs
            while (i<sentence.length && sentence[i] != ' ') i++
        }
        return res.toString()
    }

}
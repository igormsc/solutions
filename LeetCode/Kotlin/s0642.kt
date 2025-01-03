import java.util.*

class AutocompleteSystem(sentences: Array<String>, times: IntArray) {
    private val trie = Trie()
    private var t = StringBuilder()

    init {
        var i = 0
        for (s in sentences) trie.insert(s, times[i++])
    }

    fun input(c: Char): List<String> {
        val res = mutableListOf<String>()
        if (c == '#') {
            trie.insert(t.toString(), 1)
            t = StringBuilder()
            return res
        }
        t.append(c)
        val node = trie.search(t.toString()) ?: return res
        val q = PriorityQueue { a: Trie, b: Trie -> if (a.v == b.v) b.w.compareTo(a.w) else a.v - b.v }
        dfs(node, q)
        while (q.isNotEmpty()) res.add(0, q.poll().w)

        return res
    }

    private fun dfs(node: Trie?, q: PriorityQueue<Trie?>) {
        if (node == null) return
        if (node.v > 0) {
            q.offer(node)
            if (q.size > 3) q.poll()
        }
        for (nxt in node.children) dfs(nxt, q)
    }


    internal class Trie {
        var children: Array<Trie?> = arrayOfNulls(27)
        var v: Int = 0
        var w: String = ""

        fun insert(w: String, t: Int) {
            var node: Trie? = this
            for (c in w.toCharArray()) {
                val idx = if (c == ' ') 26 else c.code - 'a'.code
                if (node!!.children[idx] == null) node.children[idx] = Trie()
                node = node.children[idx]
            }
            node!!.v += t
            node!!.w = w
        }

        fun search(pref: String): Trie? {
            var node: Trie? = this
            for (c in pref.toCharArray()) {
                val idx = if (c == ' ') 26 else c.code - 'a'.code
                if (node!!.children[idx] == null) return null
                node = node.children[idx]
            }
            return node
        }
    }

}
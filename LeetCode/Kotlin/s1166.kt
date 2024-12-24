class FileSystem1166() {

    private val trie = Trie(-1)

    fun createPath(path: String, value: Int): Boolean = trie.insert(path, value)

    fun get(path: String): Int = trie.search(path)

    internal class Trie(var v: Int) {
        var children = mutableMapOf<String, Trie>()

        fun insert(w: String, v: Int): Boolean {
            var node: Trie = this
            val ps = w.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            for (i in 1..<ps.lastIndex) {
                val p = ps[i]
                if (!node.children.containsKey(p)) return false
                node = node.children[p]!!
            }
            if (node.children.containsKey(ps[ps.size - 1])) return false
            node.children[ps[ps.size - 1]] = Trie(v)
            return true
        }

        fun search(w: String): Int {
            var node: Trie? = this
            val ps = w.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            for (i in 1..ps.lastIndex) {
                val p = ps[i]
                if (!node!!.children.containsKey(p)) return -1
                node = node.children[p]
            }
            return node!!.v
        }
    }

}
class FileSystem588() {

    private val root = Trie()

    fun ls(path: String): List<String?> {
        val res = mutableListOf<String?>()
        val node = root.search(path) ?: return res
        if (node.isFile) {
            res.add(node.name)
            return res
        }
        for (v in node.children.keys) res.add(v)
        res.sortBy { it }
        return res
    }

    fun mkdir(path: String) {
        root.insert(path, false)
    }

    fun addContentToFile(filePath: String, content: String?) {
        val node = root.insert(filePath, true)
        node.content.append(content)
    }

    fun readContentFromFile(filePath: String): String {
        val node = root.search(filePath)
        return node!!.content.toString()
    }

    internal class Trie {
        var name: String? = null
        var isFile: Boolean = false
        var content: StringBuilder = StringBuilder()
        var children: MutableMap<String, Trie> = HashMap()

        fun insert(path: String, isFile: Boolean): Trie {
            var node: Trie? = this
            val ps = path.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            for (i in 1..ps.lastIndex) {
                val p = ps[i]
                if (!node!!.children.containsKey(p)) node.children[p] = Trie()
                node = node.children[p]
            }
            node!!.isFile = isFile
            if (isFile) node.name = ps.last()

            return node
        }

        fun search(path: String): Trie? {
            var node: Trie? = this
            val ps = path.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            for (i in 1..ps.lastIndex) {
                val p = ps[i]
                if (!node!!.children.containsKey(p)) return null
                node = node.children[p]
            }
            return node
        }
    }

}
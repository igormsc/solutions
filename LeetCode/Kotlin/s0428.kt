class Codec428 {

    fun serialize(root: Node?): String {
        val list =  mutableListOf<String>()
        subSr(root, list)
        return list.joinToString(",")
    }

    private fun subSr(root: Node?, list: MutableList<String>) {
        if (root == null) return
        else {
            list.add("${root.`val`}")
            list.add("${root.children.size}")
            for (child in root.children)
                subSr(child, list)
        }
    }

    fun deserialize(data: String): Node? {
        if (data.isEmpty()) return null
        val q = data.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toMutableList()
        return subDes(q)
    }

    private fun subDes(q: MutableList<String>): Node {
        val root: Node = Node(q.removeFirst().toInt())
        val size = q.removeFirst().toInt()
        root.children = (0..<size).fold(mutableListOf<Node>()) { r, i ->  r.add(subDes(q)); r}.toList()
        return root
    }
}
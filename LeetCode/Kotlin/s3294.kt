class Solution3294 {
    fun toArray(node: Node?): IntArray {
        val res =  mutableListOf<Int>()
        var nd = node
        while (nd != null) {
            res.add(nd.`val`)
            nd = nd.next
        }
        nd = node?.prev
        while (nd != null) {
            res.add(0, nd.`val`)
            nd = nd.prev
        }
        return res.toIntArray()
    }
}

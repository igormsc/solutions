class Solution3263 {
    fun toArray(root: Node?): IntArray {
        var nd = root
        val res = mutableListOf<Int>()
        while (nd != null) {
            res.add(nd.`val`)
            nd = nd.next
        }
        return res.toIntArray()
    }

}
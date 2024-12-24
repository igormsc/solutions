class Solution590 {
    fun postorder(root: Node?): List<Int> {
        val res = mutableListOf<Int>()
        if (root == null) return res
        val st = mutableListOf(root)
        while (st.isNotEmpty()) {
            val r = st.removeLast()
            res.add(r.`val`)
            r.children.forEach { if (it!=null) st.add(it) }
        }
        res.reverse()
        return res
    }
}
class Solution255 {
    fun verifyPreorder(preorder: IntArray): Boolean {
        val st = mutableListOf<Int>()
        var last = Int.MIN_VALUE
        for (x in preorder) {
            if (x < last) return false
            while (st.isNotEmpty() && st.last() < x) last = st.removeLast()
            st.add(x)
        }
        return true
    }

}
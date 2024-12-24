class Solution2053 {
    fun kthDistinct(arr: Array<String>, k: Int): String {
        val m = arr.fold(mutableMapOf<String,Int>()) { r, a -> r[a] = (r[a]?:0) + 1; r }
        var k = k
        arr.forEach { a -> if (m[a]==1) k--.also { if (it == 1) return a } }
        return ""
    }
}

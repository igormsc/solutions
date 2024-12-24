class Solution179 {
    fun largestNumber(nums: IntArray): String {
        val s = nums.foldIndexed(Array(nums.size){""}) { i, r, n -> r[i] = n.toString(); r}
        s.sortWith{ a: String, b: String -> (b+a).compareTo(a+b) }
        return s.joinToString("").trimStart('0').ifEmpty { "0" }
    }
}

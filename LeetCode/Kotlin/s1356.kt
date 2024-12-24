class Solution1356 {
    fun sortByBits(arr: IntArray): IntArray =
        arr.sortedWith { a: Int, b: Int ->
            val ca = a.countOneBits()
            val cb = b.countOneBits()
            if (ca == cb) a-b else ca-cb }.toIntArray()

}


class Solution957 {
    fun prisonAfterNDays(cells: IntArray, n: Int): IntArray {
        var res = cells
        repeat ((n-1)%14+1 ) {
            val c2 = IntArray(8)
            (1..6).forEach { i ->
                if (res[i-1] == res[i+1]) c2[i]++
            }
            res = c2
        }
        return res
    }

}

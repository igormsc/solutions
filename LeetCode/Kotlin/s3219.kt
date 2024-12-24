class Solution3219 {
    fun minimumCost(m: Int, n: Int, horizontalCut: IntArray, verticalCut: IntArray): Long {
        horizontalCut.sort()
        verticalCut.sort()
        var res = 0L
        var sumH = horizontalCut.sumOf{it.toLong()}
        var sumV = verticalCut.sumOf{it.toLong()}
        var i = horizontalCut.lastIndex
        var j = verticalCut.lastIndex
        while (i>=0 && j >= 0) {
            if (horizontalCut[i] > verticalCut[j]) {
                res += horizontalCut[i].toLong() + sumV
                sumH -= horizontalCut[i--].toLong()
            } else {
                res += verticalCut[j].toLong() + sumH
                sumV -= verticalCut[j--].toLong()
            }
        }
        return res + sumH + sumV
    }
}
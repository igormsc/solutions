class Solution670 {
    fun maximumSwap(num: Int): Int {
        val str = num.toString().toCharArray()
        var mxIdx = -1
        var mxDigit = -1
        var lIdx = -1
        var rIdx = -1
        for (i in str.lastIndex downTo 0)
            if (str[i].digitToInt() > mxDigit) {
                mxDigit = str[i].digitToInt()
                mxIdx = i
            }
            else if (str[i].digitToInt() < mxDigit) {
                lIdx = i
                rIdx = mxIdx
            }

        if (lIdx == -1) return num
        str[lIdx] = str[rIdx].also {str[rIdx] = str[lIdx]}
        return str.joinToString("").toInt()
    }
}

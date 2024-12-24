import kotlin.math.absoluteValue

class Solution1165 {
    fun calculateTime(keyboard: String, word: String): Int {
        val pos = IntArray(26)
        for (i in 0..25) pos[keyboard[i].code - 'a'.code] = i
        var i = 0
        var res = 0
        for (k in word.indices) {
            val j = pos[word[k].code - 'a'.code]
            res += (i - j).absoluteValue
            i = j
        }
        return res
    }

}
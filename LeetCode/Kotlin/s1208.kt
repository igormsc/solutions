import kotlin.math.absoluteValue

class Solution1208 {
    fun equalSubstring(s: String, t: String, maxCost: Int): Int {
        var j = 0
        s.indices.fold(maxCost){ r, i ->
            (r - (s[i].code - t[i].code).absoluteValue)
                .let { if (it<0) it + (s[j].code - t[j++].code).absoluteValue else it } }

        return s.length - j
    }
}


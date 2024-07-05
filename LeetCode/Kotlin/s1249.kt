class Solution1249 {
    fun minRemoveToMakeValid(s: String): String {
        val bs = s.toCharArray()
        var bls = 0
        var i = bs.size
        for (j in bs.lastIndex downTo 0) {
            if (bs[j] == ')') bls++
            else if (bs[j] == '(') if (bls == 0) continue else bls--
            i--
            bs[i] = bs[j]
        }
        bls = 0
        var j = 0
        while (i < bs.size) {
            if (bs[i] == '(') bls++
            else if (bs[i] == ')') if (bls == 0) {i++; continue} else bls--
            bs[j++] = bs[i++]
        }
        return bs.slice(0..<j).joinToString("")
    }

}

import java.util.*

class Solution65 {
    fun isNumber(s: String): Boolean {
        val nums = mutableMapOf( 'e' to 'e', '0' to 'd', '1' to 'd', '2' to 'd', '3' to 'd', '4' to 'd', '5' to 'd', '6' to 'd', '7' to 'd', '8' to 'd', '9' to 'd','.' to '.')
        var l = s.length
        var i = 0
        val s = s.lowercase(Locale.getDefault())
        while (i<l && s[i] == ' ') i++
        while (l>0 && s[l-1] == ' ') l--
        var bIsNum = i<l
        var cntDigits = 0
        if (i<s.length && (s[i]=='+' || s[i]=='-')) i++
        while (i<l) {
            val c = s[i]
            if (nums.containsKey(c)) {
                val v = nums[c]!!
                if (v=='e') {
                    if (cntDigits < 1) {
                        bIsNum = false
                        break
                    }
                    cntDigits = 0
                    if (nums.containsKey('.')) nums.remove('.')
                    if (i + 1 < s.length && (s[i + 1] == '+' || s[i + 1] == '-')) i++
                }
                if (v=='d') cntDigits++ else nums.remove(c).also{ if (nums.contains(v)) nums.remove(v)}
                } else {
                    bIsNum = false
                    break
                }
            i++
        }
        if (cntDigits<1) bIsNum = false
        return bIsNum
    }
}

fun main() {

    val sl = Solution678()
    var s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"

    println(sl.checkValidString(s))

}

class Solution678 {
    fun checkValidString(s: String): Boolean =
        s.fold(0 to 0) { (cMax, cMin), c ->
            when (c) {
                '(' -> cMax + 1 to cMin + 1
                ')' -> cMax - 1 to if (cMin < 1) 0 else cMin - 1
                '*' -> cMax + 1 to if (cMin < 1) 0 else cMin - 1
                else -> cMax to cMin
            }.also { if (it.first < 0) return false }
        }.let { it.second == 0 }



}

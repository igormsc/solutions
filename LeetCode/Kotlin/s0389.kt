class Solution389 {
    fun findTheDifference(s: String, t: String): Char = "$s$t".map{it.code}.reduce(Int::xor).toChar()
}


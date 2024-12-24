class Solution3304 {
    fun kthCharacter(k: Int): Char = ('a'.code + (k-1).countOneBits()).toChar()
}

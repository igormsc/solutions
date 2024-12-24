class Solution1545 {
    fun findKthBit(n: Int, k: Int): Char = ((k/k.and(-k)).shr(1).and(1).xor(k.and(1).xor(1)) + '0'.code).toChar()

}
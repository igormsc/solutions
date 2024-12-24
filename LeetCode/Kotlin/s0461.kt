class Solution461 {
    fun hammingDistance(x: Int, y: Int): Int = x.xor(y).countOneBits()
}
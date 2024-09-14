class Solution2220 {
    fun minBitFlips(start: Int, goal: Int): Int = start.xor(goal).countOneBits()
}

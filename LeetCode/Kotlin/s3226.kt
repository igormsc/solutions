class Solution3226 {
    fun minChanges(n: Int, k: Int): Int = if (n.and(k) != k) -1 else n.countOneBits() - k.countOneBits()
}

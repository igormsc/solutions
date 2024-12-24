class Solution1672 {
    fun maximumWealth(accounts: Array<IntArray>): Int = accounts.maxOf { it.sum() }
}

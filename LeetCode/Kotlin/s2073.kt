class Solution2073 {
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int =
        tickets.foldIndexed(0) { i, r, t -> r + (tickets[k] - if (i>k) 1 else 0).let { if (it>t) t else it } }

}

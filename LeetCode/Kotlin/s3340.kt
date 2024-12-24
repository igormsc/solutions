class Solution3340 {
    fun isBalanced(num: String): Boolean =
        num.foldIndexed(0 to 0) { i, r, n -> val n = n.code - '0'.code; if (i%2==0) r.first + n to r.second else r.first to r.second + n}
            .let {it.first == it.second}
}
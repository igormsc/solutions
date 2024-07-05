class Solution1614 {
    fun maxDepth(s: String): Int =
        s.fold(0 to 0) { (res, cur), c ->
            when (c) {
                        '('     -> cur + 1
                        ')'     -> cur - 1
                        else    -> cur }
            .let { maxOf(res,it) to it}
        }.first

}

class Solution681 {

    fun nextClosestTime(time: String): String {
        var res: String? = null
        val s = mutableSetOf<Char>()
        val t = time.substring(0, 2).toInt() * 60 + time.substring(3).toInt()
        var d = Int.MAX_VALUE
        var mi = 'z'
        for (c in time.toCharArray()) {
            if (c != ':') {
                s.add(c)
                if (c < mi) {
                    mi = c
                }
            }
        }

        fun dfs(curr: String) {
            if (curr.length == 4) {
                if (!chk(curr)) return
                val p = curr.substring(0, 2).toInt() * 60 + curr.substring(2).toInt()
                if (p > t && p - t < d) {
                    d = p - t
                    res = curr.substring(0, 2) + ":" + curr.substring(2)
                }
                return
            }
            for (c in s) dfs(curr + c)

        }

        dfs("")
        return if (res == null) "$mi$mi:$mi$mi" else res!!
    }

    private fun chk(t: String): Boolean {
        val h = t.substring(0, 2).toInt()
        val m = t.substring(2).toInt()
        return h in 0..23 && m in 0..59
    }
}
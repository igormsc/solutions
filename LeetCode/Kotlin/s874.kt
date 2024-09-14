class Solution874 {
    fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
        val st = obstacles.fold(mutableSetOf<Pair<Int,Int>>()) { s, o -> s.add(o[0] to o[1]); s}
        var (res, dir, x, y) = intArrayOf(0, 0, 0, 0)
        val ds = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
        commands.forEach { c ->
            when (c) {
                -2 -> dir--
                -1 -> dir++
                else -> {
                    for (j in 0..<c) {
                        if (st.contains(x + ds[dir].first to y + ds[dir].second)) break
                        x += ds[dir].first
                        y += ds[dir].second
                    }
                    res = maxOf(x*x + y*y, res)
                }
            }
            if (dir==-1) dir = 3
            if (dir==4) dir = 0
        }
        return res
    }
}
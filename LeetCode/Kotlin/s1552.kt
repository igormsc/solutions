class Solution1552 {
    fun maxDistance(position: IntArray, m: Int): Int {
        var mid = 0

        fun check(): Boolean {
            var i = 0
            var m = m
            var pos = position.first()
            while (i++ < position.lastIndex && m > 1)
                if (position[i] - pos >= mid) m-- .also { pos = position[i] }
            return m < 2
        }

        position.sort()
        var l = 1
        var r = 1_000_000_000
        while (l < r) {
            mid = (l + r) / 2 + 1
            if (check()) l = mid else r = mid - 1
        }
        return l
    }

}

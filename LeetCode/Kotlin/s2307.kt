import kotlin.math.absoluteValue

class Solution2307 {
    fun checkContradictions(equations: List<List<String>>, values: DoubleArray): Boolean {
        val mp = mutableMapOf<String, Int>()
        var n = 0
        for (e in equations)
            for (s in e)
                if (!mp.containsKey(s)) mp[s] = n++
        val p = IntArray(n) {it}
        val w = DoubleArray(n) {1.0}


        fun find(x: Int): Int {
            if (p[x] != x) {
                val root = find(p[x])
                w[x] *= w[p[x]]
                p[x] = root
            }
            return p[x]
        }

        val eps = 1e-5
        for (i in equations.indices) {
            val a = mp[equations[i][0]]!!
            val b = mp[equations[i][1]]!!
            val pa = find(a)
            val pb = find(b)
            val v = values[i]
            if (pa != pb) {
                p[pb] = pa
                w[pb] = v * w[a] / w[b]
            } else if ((v * w[a] - w[b]).absoluteValue >= eps) return true
        }
        return false
    }

}
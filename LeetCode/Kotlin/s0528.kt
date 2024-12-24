import kotlin.random.Random

class Solution528(w: IntArray) {
    private val s = IntArray(w.size + 1)
    private val random = Random(System.currentTimeMillis())

    init {
        w.indices.forEach { s[it + 1] = s[it] + w[it] }
    }

    fun pickIndex(): Int {
        val x: Int = 1 + random.nextInt(s[s.size - 1])
        var (l, r) = 1 to s.lastIndex
        while (l < r) {
            val m = (l + r) / 2
            if (s[m] >= x) r = m else l = m + 1
        }
        return l - 1
    }
}
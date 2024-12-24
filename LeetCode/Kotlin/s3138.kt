class Solution3138 {

    fun minAnagramLength(s: String): Int {
        fun check(s: String, l: Int): Boolean {
            val cnt = s.slice(0..<l).fold(IntArray(26)) { r, c -> r[c.code - 'a'.code]++;r }
            for (i in l ..<s.length step l) {
                val curr = s.slice(i..<i + l).fold(IntArray(26)) { r, c -> r[c.code - 'a'.code]++;r }
                for (k in 0..25) if (curr[k] != cnt[k]) return false
            }
            return true
        }

        for (i in 1..s.length) if (s.length % i == 0 && check(s, i)) return i
        return -1
    }
}

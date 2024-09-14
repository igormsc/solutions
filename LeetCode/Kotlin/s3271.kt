class Solution3271 {
    fun stringHash(s: String, k: Int): String {
        val b = s.map{it.code - 'a'.code}
        val res = mutableListOf<Char>()
        for (i in 0..b.lastIndex step k) {
            var j = i
            var sum = 0
            while (j<i+k && j < b.size) {
                sum += b[j++]
            }
            res.add(('a'.code + sum%26).toChar())
        }
        return res.joinToString("")
    }
}
class Solution3170 {
    fun clearStars(s: String): String {
        val b = s.toByteArray().map{it.toInt()}.toIntArray()
        val p = Array('z'.code+1) { mutableListOf<Int>() }
        for (i in b.indices)
            if (b[i] == '*'.code) {
                for (x in p)
                    if (x.isNotEmpty()) {
                        b[x.removeLast()] = '*'.code
                        break
                    }
            } else p[b[i].toInt()].add(i)
        return b.filterNot { it == '*'.code }.map{it.toChar()} .joinToString("")
    }
}

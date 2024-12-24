class Solution249 {
    fun groupStrings(strings: Array<String>): List<List<String>> {
        val m = mutableMapOf<String, MutableList<String>>()
        for (s in strings) {
            val t = s.toCharArray()
            val diff = t[0].code - 'a'.code
            t.indices.forEach { i ->
                t[i] = (t[i].code - diff).toChar()
                if (t[i] < 'a') t[i] = t[i] + 26 }
            m.computeIfAbsent(String(t)) { mutableListOf() }.add(s)
        }
        return m.values.toList()
    }

}
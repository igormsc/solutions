class ValidWordAbbr(dictionary: Array<String>) {

    private val m = mutableMapOf<String, MutableSet<String>>()

    init {
        for (s in dictionary)
            m.computeIfAbsent(abbr(s)) { mutableSetOf() }.add(s)
    }

    fun isUnique(word: String): Boolean {
        val ws: Set<String>? = m[abbr(word)]
        return ws == null || (ws.size == 1 && ws.contains(word))
    }

    private fun abbr(s: String): String {
        val n = s.length
        return if (n < 3) s else s.substring(0, 1) + (n - 2) + s.substring(n - 1)
    }

}
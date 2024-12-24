class StringIterator(compressedString: String) {

    private val d = mutableListOf<Pair<Char,Int>>()
    private var p = 0

    init {
        val n = compressedString.length
        var i = 0
        while (i < n) {
            val c = compressedString[i]
            var x = 0
            while (++i < n && compressedString[i].isDigit())
                x = x * 10 + (compressedString[i].code - '0'.code)
            d.add(c to x)
        }
    }

    fun next(): Char {
        if (!hasNext()) return ' '
        val res: Char = d[p].first
        d[p] = d[p].let{it.first to it.second - 1 }
        if (d[p].second == 0) p++
        return res
    }

    fun hasNext(): Boolean = p < d.size && d[p].second > 0

}
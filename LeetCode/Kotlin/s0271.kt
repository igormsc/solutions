class Codec {

    fun encode(strs: List<String>): String {
        val res = StringBuilder()
        for (s in strs) res.append(s.length.toChar()).append(s)
        return res.toString()
    }

    fun decode(s: String): List<String> {
        val res = mutableListOf<String>()
        var i = 0
        while (i < s.length) {
            val size = s[i++].code
            res.add(s.substring(i, i + size))
            i += size
        }
        return res
    }

}
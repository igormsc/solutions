class Solution3324 {
    fun stringSequence(target: String): List<String> {
        val lst = mutableListOf<String>()
        val sb = StringBuilder()
        target.forEach { ch ->
            sb.append('a')
            lst.add(sb.toString())
            while (sb.last() != ch) {
                val x = ((sb[sb.length - 1].code - 'a'.code + 1) % 26 + 'a'.code).toChar()
                sb.setCharAt(sb.length - 1, x)
                lst.add(sb.toString())
            }
        }
        return lst.toList()
    }
}

class Solution1271 {
    fun toHexspeak(num: String): String {
        val s = setOf('A', 'B', 'C', 'D', 'E', 'F', 'I', 'O')
        val t = java.lang.Long.toHexString(num.toLong()).uppercase().replace("0", "O").replace("1", "I")
        for (c in t.toCharArray()) if (!s.contains(c)) return "ERROR"
        return t
    }

}
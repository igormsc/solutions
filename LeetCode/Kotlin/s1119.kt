class Solution1119 {
    fun removeVowels(s: String): String {
        val res = StringBuilder()
        s.forEach { c -> if (!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) res.append(c) }
        return res.toString()
    }

}
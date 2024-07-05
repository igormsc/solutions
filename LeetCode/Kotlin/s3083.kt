class Solution3083 {
    fun isSubstringPresent(s: String): Boolean = s.windowed(2,1).find { s.contains(it.reversed()) } != null

}
class Solution3210 {
    fun getEncryptedString(s: String, k: Int): String = (k % s.length).let { s.substring(it) + s.substring(0, it) }
}

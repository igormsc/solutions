class Solution800 {
    fun similarRGB(color: String): String =
        arrayOf(color.substring(1, 3), color.substring(3, 5), color.substring(5, 7)).joinToString("", "#") { f(it) }

    private fun f(x: String): String {
        var q = x.toInt(16)
        q = q / 17 + (if (q % 17 > 8) 1 else 0)
        return String.format("%02x", 17 * q)
    }

}


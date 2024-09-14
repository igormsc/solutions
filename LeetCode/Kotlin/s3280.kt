class Solution3280 {
    fun convertDateToBinary(date: String): String = date.split("-").joinToString("-") { it.toInt().toString(2) }
}
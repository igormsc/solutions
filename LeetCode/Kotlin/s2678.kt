class Solution2678 {
    fun countSeniors(details: Array<String>): Int = details.count { it.substring(11,13) > "60" }
}

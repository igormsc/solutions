class Solution {
    fun validStrings(n: Int): List<String> =
        if (n==1) listOf("0", "1") else {
            validStrings(n-1).fold(mutableListOf()) { r, s ->
                if (s.last() == '1') {r.add("${s}0")}
                r.add("${s}1")
                r }
        }
}

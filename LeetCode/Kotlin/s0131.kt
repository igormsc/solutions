class Solution131 {
    fun partition(s: String): List<List<String>> {
        val pars = mutableListOf<List<String>>()
        fun calc(start: Int, par: MutableList<String>) {
            val n = s.length
            if (start == n) pars.add(par.toList())
            else {
                (start..<n).forEach{ i ->
                    if (s.isPalindrome(start, i)) {
                        par.add(s.slice((start..i+1)))
                        calc(i+1, par)
                        par.removeLast()
                    }
                }
            }
        }
        calc(0, mutableListOf())
        return pars
    }

    private fun String.isPalindrome(l: Int, r: Int): Boolean {
        var l = l
        var r = r
        while (l<r) if (this[l++] != this[r--]) return false
        return true
    }

}

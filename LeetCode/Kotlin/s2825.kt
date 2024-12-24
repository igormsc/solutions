class Solution2825 {
        fun canMakeSubsequence(str1: String, str2: String): Boolean {
            var (i, j) = -1 to 0
            while (++i < str1.length && j < str2.length)
                if (str1[i] == str2[j] || str1[i].code+1 == str2[j].code || str1[i].code-25 == str2[j].code) j++
            return j == str2.length
        }
}

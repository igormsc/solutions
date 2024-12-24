class Solution1092 {
    fun shortestCommonSupersequence(str1: String, str2: String): String {
        val (n,m) = str1.length to str2.length
        var t = Array(n+1) {IntArray(m+1)}
        val res = StringBuilder()
        (0..n).forEach{ i->
            (0..m).forEach{ j->
                if (i == 0 || j == 0) t[i][j] = 0
                else if (str1[i-1] == str2[j-1]) t[i][j] = t[i-1][j-1] + 1
                else {
                    if (t[i-1][j]>t[i][j-1]) t[i][j] = t[i-1][j]
                    else t[i][j] = t[i][j-1]
                }
            }
        }

        var (i,j) = n to m
        while (i > 0 && j > 0) {
            if (str1[i-1] == str2[j-1]) {
                i--
                j--
                res.append(str1[i])
            } else {
                if (t[i-1][j]>t[i][j-1]) res.append(str1[--i])
                else res.append(str2[--j])
                }
            }
        while (i > 0) res.append(str1[--i])
        while (j > 0) res.append(str2[--j])
        return res.reverse().toString()
    }
}

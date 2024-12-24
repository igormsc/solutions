internal class Solution3297 {
    fun validSubstringCount(word1: String, word2: String): Long {
        var res = 0L
        val mp = Array(255) { IntArray(2) }
        var (l,r,size,n) = intArrayOf(0,0,0,word1.length)
        word2.forEach { mp[it.code][1]++ }

        val f = fun() {
            while (size == word2.length && l <= r) {
                res += (n - r + 1).toLong()
                mp[word1[l].code][0]--
                if (mp[word1[l].code][1] > 0 && mp[word1[l].code][0] < mp[word1[l].code][1]) size--
                l++
            }
        }

        while (r < n) {
            f()
            if (mp[word1[r].code][1] > 0 && mp[word1[r].code][0] < mp[word1[r].code][1]) size++
            mp[word1[r].code][0]++
            r++
        }
        f()
        return res
    }
}
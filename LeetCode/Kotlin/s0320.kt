class Solution320 {

    fun generateAbbreviations(word: String): List<String> {
        val res =  mutableListOf<String>()

        fun bt(pos: Int, cur: String, cnt: Int) {
            var cur = cur
            if (pos == word.length) {
                if (cnt > 0) cur += cnt
                res.add(cur)
            } else {
                bt(pos + 1, cur, cnt + 1)
                bt( pos + 1, cur + (if (cnt > 0) cnt else "") + word[pos], 0)
            }
        }

        bt( 0, "", 0)

        return res
    }

}




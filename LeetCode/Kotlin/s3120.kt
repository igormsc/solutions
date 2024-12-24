class Solution3120 {
    fun numberOfSpecialChars(word: String): Int =
        word.fold(BooleanArray(26) to BooleanArray(26)) { (lc, uc), c ->
            if (c.isLowerCase()) lc[c.code - 'a'.code] = true else uc[c.code - 'A'.code] = true
            lc to uc
        }.let { (lc, uc) -> lc.zip(uc).count{ it.first.and(it.second) } }

}


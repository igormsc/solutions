class Solution1255 {
    fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
        if (words.isEmpty() || letters.isEmpty() || score.isEmpty()) return 0
        val cnt = letters.fold(IntArray(score.size)) { r, l -> r[l.code - 'a'.code]++; r }

        fun backtrack(index: Int): Int =
            (index..words.lastIndex).fold(0) { max, i ->
                var isValid = true
                val sum = words[i].sumOf { c ->
                    cnt[c.code - 'a'.code]--
                        .also { if (it<=0) isValid = false }
                    score[c.code - 'a'.code]
                }
                maxOf(if (isValid) sum + backtrack(i + 1) else max, max)
                    .also { words[i].forEach { cnt[it.code - 'a'.code]++ } }
            }
        return backtrack(0)
    }

    }

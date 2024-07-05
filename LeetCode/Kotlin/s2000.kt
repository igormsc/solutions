class Solution2000 {
    fun reversePrefix(word: String, ch: Char): String =
        word.indexOf(ch).let { if (it<0)  word else word.slice(0..it).reversed() + word.slice(it+1..word.lastIndex)}
}
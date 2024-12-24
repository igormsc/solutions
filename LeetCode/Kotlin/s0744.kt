class Solution744 {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        val n = letters.size
        var (l, r) = 0 to n
        while (l<r) {
            val m = l + (r-l)/2
            if (letters[m] > target) r = m else l = m+1
        }
        return letters[l%n]
    }
}

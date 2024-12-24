class Solution374:GuessGame() {
    override fun guessNumber(n: Int): Int {
        var (l, r) = 1 to n
        while (l <= r) {
            val m = l + (r - l) / 2
            when (guess(m)) {
                0 -> return m
                -1 -> r = m - 1
                1 -> l = m + 1
            }
        }
        return -1
    }
}


    abstract class GuessGame{
        abstract fun guessNumber(n:Int):Int
        fun guess(m:Int):Int = 0
    }



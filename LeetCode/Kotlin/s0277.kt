class Solution277: Relation() {
    override fun findCelebrity(n: Int): Int {
        var res = 0
        for (i in 1..<n)
            if (knows(res, i)) res = i

        for (i in 0..<n)
            if ((res != i) && (knows(res, i) || !knows(i, res))) return -1

        return res
    }
}

    abstract class Relation() {
        abstract fun findCelebrity(n: Int): Int
        fun knows(i: Int, j: Int): Boolean = false
    }
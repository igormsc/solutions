class Solution278: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        var (l,r) = 1 to n
        while (l<r) {
            val m= l+(r-l)/2
            if (!isBadVersion(m)) l = m+1 else r = m
        }
        return l
    }
}

abstract class VersionControl{
    abstract fun firstBadVersion(n: Int): Int
    fun isBadVersion(n: Int) : Boolean = false
}
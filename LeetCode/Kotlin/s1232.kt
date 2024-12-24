class Solution1232 {
    fun checkStraightLine(c: Array<IntArray>): Boolean =
        !(2..c.lastIndex).any { (c[1][0] - c[0][0]) *(c[it][1]-c[0][1]) != (c[1][1] - c[0][1])*(c[it][0]-c[0][0]) }

}

class Solution3197 {
    fun minimumSum(grid: Array<IntArray>): Int {

        var res = 100_000_000

        fun minSum(xs: Int, ys: Int, xe: Int, ye: Int): Int {
            var xm = -1
            var ym = -1
            var xsm = 100_000
            var ysm = 100_000
            (xs..xe).forEach { i ->
                (ys..ye).forEach { j ->
                    if (grid[i][j] == 1) {
                        xm = maxOf(xm, i)
                        ym = maxOf(ym, j)
                        xsm = minOf(xsm, i)
                        ysm = minOf(ysm, j)
                    }
                }
            }
            return if (xm == -1) 0 else (xm - xsm + 1) * (ym - ysm + 1)
    }


        fun part(xs: Int, ys: Int, xe: Int, ye: Int, sum: Int, pl: Int) {
            var sum = sum
            if (pl <= 0) {
                sum += minSum(xs, ys, xe, ye)
                res = minOf(res, sum)
                return
            }

            (ys + 1..ye).forEach { yp ->
                val lsum = minSum(xs, ys, xe, yp - 1)
                val rsum = minSum(xs, yp, xe, ye)
                part(xs, yp, xe, ye, sum + lsum, pl - 1)
                part(xs, ys, xe, yp - 1, sum + rsum, pl - 1)
            }

            (xs + 1..xe).forEach { xp ->
                val usum = minSum(xs, ys, xp - 1, ye)
                val dsum = minSum(xp, ys, xe, ye)
                part(xp, ys, xe, ye, sum + usum, pl - 1)
                part(xs, ys, xp - 1, ye, sum + dsum, pl - 1)
            }
        }

        part(0, 0, grid.lastIndex, grid[0].lastIndex, 0, 2)
        return res
    }

}

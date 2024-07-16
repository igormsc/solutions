import java.io.BufferedReader
import java.io.InputStreamReader

// 2. Самый дешевый путь

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n,m) = reader.readLine().trim().split(' ').map(String::toInt)
    val grid = (0..<n).fold(Array(n){IntArray(m)}) { r, i ->
        r[i] = reader.readLine().trim().split(' ').map(String::toInt).toIntArray()
        r }
    reader.close()

    val sl = Solution64()
    val r = sl.minPathSum(grid)
    println(r)
}


// leetcode 64

class Solution64 {
    fun minPathSum(grid: Array<IntArray>): Int {
        grid.indices.forEach { i ->
            grid[i].indices.forEach { j ->
                if (i==0 && j!=0) grid[i][j] += grid[i][j-1]
                if (i!=0 && j==0) grid[i][j] += grid[i-1][j]
                if (i!=0 && j!=0) grid[i][j] += minOf(grid[i-1][j],  grid[i][j-1])
            }
        }
        return grid.last().last()
    }
}

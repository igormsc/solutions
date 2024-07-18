import java.io.BufferedReader
import java.io.InputStreamReader

// 3. Вывести маршрут максимальной стоимости

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    var (n,m) = reader.readLine().trim().split(' ').map{ it.toInt()-1}
    val grid = (0..n).fold(Array(n+1){IntArray(m+1)}) { r, i ->
        r[i] = reader.readLine().trim().split(' ').map(String::toInt).toIntArray()
        r }
    reader.close()

    grid.indices.forEach { i ->
        grid[i].indices.forEach { j ->
            if (i==0 && j!=0) grid[i][j] += grid[i][j-1]
            if (i!=0 && j==0) grid[i][j] += grid[i-1][j]
            if (i!=0 && j!=0) grid[i][j] += maxOf(grid[i-1][j],  grid[i][j-1])
        }
    }

    val p = mutableListOf<Char>()
    while (n>-1 && m>-1) {
        val t = if (n>0) grid[n-1][m] else -1
        val l = if(m>0)   grid[n][m-1] else -1
        if (t > l) n--.also { p.add('D') }
        else m--.also { p.add('R') }
    }

    p.reverse()
    println(grid.last().last())
    println(p.drop(1).joinToString(" "))
}


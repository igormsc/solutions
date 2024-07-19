import java.io.BufferedReader
import java.io.InputStreamReader

// 92. Туризм

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    fun getInp(): Array<IntArray> {
        val n = reader.readLine().trim().toInt()
        return (1..n).fold(Array(n) { IntArray(2) }) { r, i -> r[i - 1] = reader.readLine().trim().split(' ').map(String::toInt).toIntArray(); r } }

    val way = getInp()
    val right = IntArray(way.size+1)
    val left = IntArray(way.size+1)

    (1..way.lastIndex).forEach{ i ->
        val h = maxOf(way[i][1] - way[i-1][1], 0)
        right[i+1] = right[i] + h
    }
    (way.lastIndex downTo 1).forEach{ i ->
        val h = maxOf(way[i-1][1]-way[i][1], 0)
        left[i] = left[i+1] + h
    }

    val route = getInp()
    reader.close()

    route.forEach { r ->
        val (i, j) = r
        println(if (i>j) left[j] - left[i] else right[j] - right[i])
    }
}
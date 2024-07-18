import java.io.BufferedReader
import java.io.InputStreamReader

// 137. Минимальный прямоугольник

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().trim().toInt()
    val crds = (1..n).fold(mutableListOf<IntArray>()) { r, _ -> r.add(reader.readLine().trim().split(' ').map(String::toInt).toIntArray()); r}
    reader.close()

    val r =
    crds.fold(intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE, Int.MIN_VALUE, Int.MIN_VALUE)) { m, c ->
            intArrayOf(minOf(m[0], c[0]), minOf(m[1], c[1]), maxOf(m[2], c[0]), maxOf(m[3], c[1])) }
    println(r.joinToString(" "))
}

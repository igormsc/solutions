import java.io.BufferedReader
import java.io.InputStreamReader

// 135. Операционные системы lite

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    reader.readLine().trim()
    val m = reader.readLine().trim().toInt()
    val iv = (1..m).fold(mutableListOf<IntArray>()) { r, _ ->
        r.add(reader.readLine().trim().split(' ').map(String::toInt).toIntArray()); r }
    reader.close()

    var cnt = 0
    val rng = mutableListOf<IntArray>()
    iv.reversed().forEach { i ->
        if (rng.find {i[0]<=it[1] && i[1]>=it[0]} != null) cnt--
        cnt++
        rng.add(i)
    }
    println(cnt)
}

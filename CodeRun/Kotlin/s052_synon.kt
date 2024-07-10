import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().toInt()
    val m = (1..n).fold(mutableMapOf<String,String>()) { r, _ ->
        val (k, v) = reader.readLine().split(' ').map{it.trim()}
        r[k] = v
        r[v] = k
        r }

    val q = reader.readLine().trim()
    println(m[q]?:"")

    reader.close()

}
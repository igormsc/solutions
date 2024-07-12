import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val d = mutableListOf<String>()
    repeat(4){
        val s = reader.readLine()
            .trim().replace("[()-]".toRegex(), "")
            .let{ if (it.length > 10) it.substring(it.lastIndex-9..it.lastIndex) else it }
            .let{ if (it.length == 7) "495${it}" else it }
        d.add(s) }

    val n = d.removeFirst()!!
    repeat(3) { println(if (n == d.removeFirst()) "YES" else "NO") }

    reader.close()
}
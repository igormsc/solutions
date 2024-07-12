import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val q = mutableListOf<String>()
    while (true) {
        val line = reader.readLine()?: break
        val r =
            when  {
                line.startsWith("push") -> "ok" .also { val s = line.split(" "); if (s.size==2 && s[1].isNotEmpty()) q.add(s[1]) }
                line.startsWith("back") -> if (q.isNotEmpty()) q.last() else "error"
                line.startsWith("pop") -> if (q.isNotEmpty()) q.removeLast() else "error"
                line.startsWith("size") -> q.size.toString()
                line.startsWith("clear") -> "ok" .also { q.clear() }
                line.startsWith("exit") -> "bye"
                else -> "error"
            }
        println(r)
        if (r=="bye") break
    }
    reader.close()
}
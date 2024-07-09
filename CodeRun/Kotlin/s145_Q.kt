import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val q = mutableListOf<String>()
    while (true) {
        val line = reader.readLine()?: break
        val r =
            when  {
                line.startsWith("push") -> "ok" .also { val s = line.split(" "); if (s.size==2 && s[1].isNotEmpty()) q.add(s[1]) }
                line.startsWith("front") -> if (q.isNotEmpty()) q.first() else "error"
                line.startsWith("pop") -> if (q.isNotEmpty()) q.removeFirst() else "error"
                line.startsWith("size") -> q.size.toString()
                line.startsWith("clear") -> "ok" .also { q.clear() }
                line.startsWith("exit") -> "bye"
                else -> "error"
            }
        writer.write(r)
        writer.newLine()
        writer.flush()

        if (r=="bye") break
    }

    reader.close()
    writer.close()
}
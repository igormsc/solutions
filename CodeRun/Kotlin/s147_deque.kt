import java.io.*

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val q = ArrayDeque<String>()
    var line: String? = null
    while (true) {
        try {
            line = reader.readLine()
        } catch (_: IOException) {}
        if (line == null) break
        val r =
            when  {
                line.startsWith("push_front") -> "ok" .also { val s = line.split(" "); if (s.size==2 && s[1].isNotEmpty()) q.addFirst(s[1].trim()) }
                line.startsWith("push_back") -> "ok" .also { val s = line.split(" "); if (s.size==2 && s[1].isNotEmpty()) q.addLast(s[1].trim()) }
                line.startsWith("front") -> if (q.isNotEmpty()) q.first() else "error"
                line.startsWith("back") -> if (q.isNotEmpty()) q.last() else "error"
                line.startsWith("pop_front") ->  if (q.isNotEmpty()) q.removeFirst() else "error"
                line.startsWith("pop_back") -> if (q.isNotEmpty()) q.removeLast() else "error"
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
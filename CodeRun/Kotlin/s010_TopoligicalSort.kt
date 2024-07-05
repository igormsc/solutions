import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val inp = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
    val (n, m) = inp[0] to inp[1] // n - nodes num, m - edges.
    val adj = (0..<m).fold(Array(n+1) { mutableListOf<Int>() }) { r, i ->
        val inp = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
        r[inp[0]].add(inp[1])
        r
    }
    reader.close()

    val indegree =IntArray(n+1)
    adj.forEach{ it.forEach{ indegree[it]++ } }
    val q = (1..n).fold(mutableListOf<Int>()){ r, i -> if (indegree[i]==0) r.add(i); r }
    val res = mutableListOf<Int>()
    while (q.isNotEmpty()) {
        val node = q.removeFirst()!!
        res.add(node)
        adj[node].forEach {
            indegree[it]--
            if (indegree[it] == 0) q.add(it)
        }
    }

    val r = if (res.size != n) "-1" else res.joinToString(" ")
    writer.write(r)
    writer.newLine()

    writer.close()
}
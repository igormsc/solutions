import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val inp = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
    val (n, m) = inp[0] to inp[1] // n - nodes num, m - edges.
    val g = (0..<m).fold(Array(n+1) { mutableListOf<Int>() }) { r, i ->
        val inp = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
        r[inp[0]].add(inp[1])
        r[inp[1]].add(inp[0])
        r
    }
    reader.close()

    val component = mutableMapOf<Int, Int>()

    fun dfs(v: Int, num: Int) {
        component[v] = num
        g[v].forEach { u -> if (!component.contains(u)) dfs(u, num) }
    }

    var num = 0
    (1..n).forEach { v -> if (!component.contains(v)) { num++; dfs(v,num) } }
    val r = Array(num+1) { mutableListOf<Int>() }
    component.forEach { (k, v) -> r[v].add(k) }

    writer.write(num.toString())
    writer.newLine()
    r.drop(1).forEach {  c ->
        writer.write(c.size.toString())
        writer.newLine()
        writer.write(c.joinToString(" "))
        writer.newLine()
    }
    writer.close()
}

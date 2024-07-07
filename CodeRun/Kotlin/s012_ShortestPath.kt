import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val nodes = reader.readLine().toInt()
    val adj = (1..nodes).fold(Array(nodes) { BooleanArray(nodes) }) { r, i ->
        r[i - 1] = reader.readLine().trim().split(" ").map { it == "1" }.toBooleanArray()
        r
    }
    val inp = reader.readLine().split(" ").map(String::toInt)
    val (start, end) = inp[0] - 1 to inp[1] - 1
    reader.close()

// https://www.geeksforgeeks.org/shortest-path-unweighted-graph/

    val dist = IntArray(nodes) { -1 }.also { it[start] = 0 }
    val q = mutableListOf(start)
    val parents = IntArray(nodes) { -1 }

    while (q.isNotEmpty()) {
        val curr = q.removeFirst()
        (0..<nodes).forEach {
            if (adj[curr][it] && dist[it] == -1) {
                parents[it] = curr
                q.add(it)
                dist[it] = dist[curr] + 1
            }
        }
    }

    val path =  if (dist[end] == -1) mutableListOf()
                else {
                    var curr = end
                    val p = mutableListOf(curr + 1)
                    while (parents[curr] != -1) p.add(parents[curr] + 1).also { curr = parents[curr] }
                    //p.reverse()
                    p
                }

    val r = if (path.isNotEmpty()) path.size - 1 else -1

    writer.write(r.toString())
    writer.newLine()
    writer.close()
}


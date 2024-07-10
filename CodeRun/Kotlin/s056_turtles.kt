import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val total = reader.readLine().toInt()
    val exist = mutableSetOf<Pair<Int, Int>>()
    val r = (1..total).count { i ->
        val (f,b) = reader.readLine().split(" ").map { it.toInt() }
        f >=0 && b >=0 && f+b+1 == total && !exist.contains(f to b).also {exist.add(f to b)}
    }

    reader.close()
    writer.write(r.toString())
    writer.newLine()

    writer.close()
}
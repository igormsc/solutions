import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val data = (1..5).fold(mutableListOf<Int>()) { r, _ -> r.add(reader.readLine().trim().toInt()); r }
    reader.close()

    val brick = data.slice(0..2).sorted()
    val wall = data.slice(3..4).sorted()
    val r = if (brick.first() <= wall.first() && brick[1] <= wall.last()) "YES" else "NO"

    writer.write(r)
    writer.newLine()
    writer.close()
}
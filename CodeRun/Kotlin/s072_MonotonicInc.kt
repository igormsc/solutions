import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val r = reader.readLine().split(" ").map{it.toInt()}.windowed(2,1).all{ it[1] > it[0] }
    reader.close()

    writer.write(if (r) { "YES" } else {"NO" })
    writer.newLine()
    writer.close()
}
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    reader.readLine()
    val r = reader.readLine().split(" ").map{it.toInt()}.fold(mutableMapOf<Int,Int>()){ r, n -> r[n] = (r[n]?:0) + 1; r }.count { it.value == 1 }

    reader.close()
    writer.write(r.toString())
    writer.close()
}
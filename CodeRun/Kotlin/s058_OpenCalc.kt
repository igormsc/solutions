import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val keys = reader.readLine().toCharArray().filter { it.isDigit() }.toSet()
    val nums = reader.readLine().toCharArray().toSet()
    reader.close()

    val r = nums.subtract(keys).size

    writer.write(r.toString())
    writer.newLine()
    writer.close()
}
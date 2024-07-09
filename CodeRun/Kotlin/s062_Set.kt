import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val nums = reader.readLine().split(' ').map { it.toInt() }.toSet()
    reader.close()
    writer.write(nums.size.toString() + "\n")
    writer.close()
}


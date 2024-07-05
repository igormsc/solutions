import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.absoluteValue

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    reader.readLine()
    val nums = reader.readLine().split(" ").map{it.toInt()}
    val target = reader.readLine().trim().toInt()
    reader.close()

    val m = nums.fold(10_000){ r, n -> if ( (r-target).absoluteValue > (n-target).absoluteValue ) n else r }

    writer.write(m.toString())
    writer.newLine()
    writer.close()
}
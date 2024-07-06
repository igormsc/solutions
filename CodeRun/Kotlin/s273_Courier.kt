import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.absoluteValue

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val inp = reader.readLine().split(" ").map { it.toInt() }
    val start = inp.first()
    val coords = reader.readLine().split(" ").map { it.toInt() }
    val (min, max) = coords.min() to coords.max()
    val dist =
    when {
        start < min ->  (max - start).absoluteValue
        start > max -> (start - min).absoluteValue
        else -> {
            val (dMin, dMax) = (start - min).absoluteValue to (start - max).absoluteValue
            if (dMin < dMax)  dMin*2 + (max-start).absoluteValue else dMax*2 + (start-min).absoluteValue
        }
    }
    reader.close()
    writer.write(dist.toString())
    writer.newLine()
    writer.close()
}
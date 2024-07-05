import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt() // total num

    val lng = (1..n).fold(mutableMapOf<String, Int>()) { r, _ ->
                val m = reader.readLine().toInt()
                (1..m).forEach {
                    val l = reader.readLine()
                    r[l] = (r[l] ?: 0) + 1
                    }
                r }
    reader.close()

    val lngAll = lng.filterValues { it == n }

    fun doOutput(m: Map<String,Int>) {
        writer.write(m.size.toString())
        writer.newLine()
        m.forEach { (k, _) ->
            writer.write(k)
            writer.newLine()
        }
    }

    doOutput(lngAll)
    doOutput(lng)
    writer.close()
}


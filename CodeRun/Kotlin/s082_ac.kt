import java.io.BufferedReader
import java.io.InputStreamReader


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (room, cond) = reader.readLine().split(' ').map(String::toInt)
    val mode = reader.readLine().trim()

    val r =
        when (mode) {
            "freeze" -> minOf(room, cond)
            "heat" -> maxOf(room, cond)
            "auto" -> cond
            else -> room
        }
    println(r)

    reader.close()
}

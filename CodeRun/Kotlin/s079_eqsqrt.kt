import java.io.BufferedReader
import java.io.InputStreamReader


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    // sqrt(x*a +b) = c -> x = (c*c - b) / a

    val a = reader.readLine().trim().toInt()
    val b = reader.readLine().trim().toInt()
    val c = reader.readLine().trim().toInt()

    when {
        c < 0 -> println("NO SOLUTION")
        a == 0 && b >=0 && b == c*c -> println("MANY SOLUTIONS")
        a == 0 -> println("NO SOLUTIONS")
        else -> {
            val x = (c*c - b) / a
            println(x)
        }
    }

    reader.close()
}

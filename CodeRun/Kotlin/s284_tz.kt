import java.io.BufferedReader
import java.io.InputStreamReader


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val start = reader.readLine().trim().split(":").map(String::toInt).let{it[0]*60+it[1]}
    val end = reader.readLine().trim().split(":").map(String::toInt).let{it[0]*60+it[1]}
    val tz = reader.readLine().trim().toInt() * 60
    val d = (end - tz - start).let{ it + if (it<0) 24*60 else 0}.let { it + if (end-tz<0) 24*60 else 0 }
    val h = d / 60
    val m = d - h*60
    println("%d:%02d".format(h%24, m))

    reader.close()
}

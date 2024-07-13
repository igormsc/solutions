import java.io.BufferedReader
import java.io.InputStreamReader


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val start = reader.readLine().trim().split(":").map(String::toInt).let{ it[0]*60*60 + it[1]*60 + it[2] }
    val sync = reader.readLine().trim().split(":").map(String::toInt).let{ it[0]*60*60 + it[1]*60 + it[2] }
    val end = reader.readLine().trim().split(":").map(String::toInt).let{ it[0]*60*60 + it[1]*60 + it[2] }
    val endA = if (end<start) end + 24*60*60 else end
    val delay = (endA-start)/2 + if ((endA-start)%2==0) 0 else 1
    val time = sync + delay
    val s = time % 60
    val m = ((time - s) / 60) % 60
    val h = ((time - m * 60 - s) / 3600) % 24
    println("%02d:%02d:%02d".format(h,m,s))

    reader.close()
}
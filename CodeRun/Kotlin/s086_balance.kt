import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val acc = mutableMapOf<String,Long>()
    while (true) {
        val line = reader.readLine()?: break
        val s = line.trim().split(" ")
        when  {
            line.startsWith("DEPOSIT") -> {
                if (s.size==3 && s[1].isNotEmpty() && s[2].isNotEmpty()) { val n = s[1].trim(); acc[n] = (acc[n]?:0) + s[2].toLong() }
            }
            line.startsWith("WITHDRAW") -> {
                if (s.size==3 && s[1].isNotEmpty() && s[2].isNotEmpty()) { val n = s[1].trim(); acc[n] = (acc[n]?:0) - s[2].toLong() }
            }
            line.startsWith("TRANSFER") -> {
                if (s.size==4 && s[1].isNotEmpty() && s[2].isNotEmpty() && s[3].isNotEmpty()) {
                    val f = s[1].trim()
                    val t = s[2].trim()
                    val a = s[3].trim().toLong()
                    acc[f] = (acc[f]?:0) - a
                    acc[t] = (acc[t]?:0) + a
                }
            }
            line.startsWith("INCOME") -> {
                if (s.size==2 && s[1].isNotEmpty()) {
                    val p = s[1].trim().toLong()
                    acc.forEach{ (k, v) -> if (v>0) acc[k] = v + v * p / 100}
                }
            }
            line.startsWith("BALANCE") -> {
                if (s.size == 2 && s[1].isNotEmpty()) {
                    val n = s[1].trim()
                    if (acc.contains(n)) println(acc[n]) else println("ERROR")
                }
            }
            else -> println("ERROR")
        }
    }

    reader.close()
}
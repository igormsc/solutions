import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    var n = 0
    val EOF = -2_000_000_000
    var prev = EOF
    var bConst = false
    var bAsc = false
    var bDesc = false
    var cnt = 0

    while (n != EOF) {
        cnt++
        n = reader.readLine().trim().toInt()
        if (prev != EOF && n != EOF) {
            if (prev == n) bConst = true
            if (prev < n) bAsc = true
            if (prev > n) bDesc = true
        }
        prev = n
    }
    val r =
        when {
            (bConst && !bAsc && !bDesc)-> "CONSTANT"
            bAsc && !bConst && !bDesc -> "ASCENDING"
            bAsc && bConst && !bDesc -> "WEAKLY ASCENDING"
            bDesc && !bConst && !bAsc -> "DESCENDING"
            bDesc && bConst && !bAsc -> "WEAKLY DESCENDING"
            else -> "RANDOM"
        }
    println(r)

    reader.close()
}


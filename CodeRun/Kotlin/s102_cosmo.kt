import java.io.BufferedReader
import java.io.InputStreamReader


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n,a,b,w,h) = reader.readLine().trim().split(' ').filter{it.isNotBlank()}.map(String::toLong)
    reader.close()

    var l = 0L
    var r = minOf(w, h)
    while (l+1L<r) {
        val m = (l+r)/2L
        val aa = a + 2L*m
        val bb = b + 2L*m
        if (aa == 0L || bb == 0L) { l = 0L; break}
        val x = maxOf((w / aa) * (h / bb), (h / aa) * (w / bb))
        if (x>=n) l = m else r = m
    }
    println(l)

}


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File

//109. Медиана объединения-2

fun main(args: Array<String>) {

    val reader = BufferedReader(File("input.txt").reader())
    val (n,k) = reader.readLine().trim().trim().split(' ').map(String::toInt)

    fun gen(l: Int, x1:Int, d1: Int, a: Int, c: Int, m: Int): IntArray {
        val r = IntArray(l){x1}
        var d = d1
        (1..<l).forEach{
            r[it] = r[it-1] + d
            d = (a*d+c)%m }
        return r
    }

    val sqs = (0..<n).fold(Array(n){IntArray(k)}) { r, i ->
        val inp = reader.readLine().trim().split(' ').map{it.trim()}.filter{it.isNotBlank()}
        if (inp.size == 5) {val (x1, d1, a, c, m) = inp.map(String::toInt); r[i] = gen(k, x1, d1, a, c, m)}
        r }
    reader.close()

    fun bs(sq: IntArray, x: Int): Int {
        var l = -1
        var r = sq.size
        while (r>l+1) {
            val m = (l+r)/2
            if (m in sq.indices && sq[m] >= x) r = m else l = m
        }
        return r
    }

    fun median(sq1: IntArray, sq2: IntArray): Int {
        val ln = sq1.size
        var l = minOf(sq1.first(), sq2.first()) - 1
        var r = maxOf(sq1.last(), sq2.last()) + 1
        while (r>l+1) {
            val m = (l+r)/2
            val c = bs(sq1,m) + bs(sq2, m)
            if (c<ln) l = m else r = m
        }
        return l
    }

    val fOut = File("output.txt").writer()
    val writer = BufferedWriter(fOut)
    sqs.indices.forEach{ i ->
        (i+1..sqs.lastIndex).forEach { j ->
            writer.write("%d\n".format(median(sqs[i], sqs[j])))
        }
    }
    writer.flush()
    writer.close()
    fOut.close()
}

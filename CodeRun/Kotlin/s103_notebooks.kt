import java.io.BufferedReader
import java.io.InputStreamReader

// 103. Расстановка ноутбуков

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().trim().split(' ').map(String::toLong).toTypedArray()
    reader.close()

    if (n[1]>n[0]) n[0] = n[1].also {n[1]=n[0]}
    if (n[3]>n[2]) n[3] = n[2].also {n[2]=n[3]}
    if (n[2]>n[0]) { n[0] = n[2].also {n[2]=n[0]}; n[1] = n[3].also {n[3]=n[1]} }

    val s = LongArray(4)
    s[0] = n[0]
    s[1] = n[1]+n[3]
    s[2] = maxOf(n[1],n[2])
    s[3] = n[0]+n[3]

    val r = if (s[0]*s[1]<s[2]*s[3]) s[0] to s[1] else s[2] to s[3]
    println("${r.first} ${r.second}")
}

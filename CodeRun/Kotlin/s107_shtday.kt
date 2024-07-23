import java.io.BufferedReader
import java.io.InputStreamReader

// 107. Субботник

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, b, c) = reader.readLine().trim().split(' ').map(String::toInt)
    val nums = (0..<n).fold(mutableListOf<Int>()) { r, _ -> r.add(reader.readLine().trim().toInt()); r}
    reader.close()

    fun chk(m: Int): Boolean {
        var i = 0
        var x = 0
        while (i<n-c+1) if (nums[i+c-1]-nums[i]<=m) x++.also{i +=c} else i++
        return x >= b
    }

    nums.sort()
    var l = -1
    var r = nums.last() - nums.first() + 1
    while (r>l+1) {
        val m = (l+r)/2
        if (chk(m)) r = m else l = m
    }
    println(r)
}

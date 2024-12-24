class Solution43 {
    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") return "0"
        val v = IntArray(num1.length + num2.length)
        (num1.lastIndex downTo 0).forEach { i ->
            (num2.lastIndex downTo 0).forEach { j ->
                v[i+j+1] += (num1[i].code -'0'.code)*(num2[j].code -'0'.code)
                v[i+j] += v[i+j+1]/10
                v[i+j+1] %=10
            }
        }
        var i = 0
        while (i<v.size && v[i] == 0) i++
        return v.slice(i..v.lastIndex).map{ (it + '0'.code).toChar()}.joinToString("")
    }
}

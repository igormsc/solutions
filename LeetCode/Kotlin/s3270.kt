class Solution3270 {
    fun generateKey(num1: Int, num2: Int, num3: Int): Int {
        val nm = arrayOf(num1, num2, num3)
        val s = StringBuilder()
        while (nm.any{it>0}) {
            s.insert(0,nm.minOfOrNull { it % 10 }.toString())
            nm.indices.forEach { nm[it] /= 10 }
        }
        return s.toString().toInt()
    }
}

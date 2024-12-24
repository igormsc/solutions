class Solution3064 : Problem() {

    fun findNumber(): Int {
        var n = 0
        for (i in 0..31)
            if (commonSetBits(1 shl i) > 0) n = n or (1 shl i)
        return n
    }

}

open class Problem {
    fun commonSetBits(bits: Int) = 0
    fun commonBits(i: Int): Int = 0
}
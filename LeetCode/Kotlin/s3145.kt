class Solution3145 {
    fun findProductsOfElements(queries: Array<LongArray>): IntArray {

        fun cnt(x: Int): Int = if (x==0) 0 else {
            val b = Int.SIZE_BITS - x.countLeadingZeroBits() - 1
            val v = 1 shl b
            val res = b * (v shr 1)
            res + cnt(x-v) + x - v }

        fun mul(x: Int): Int = if (x==0) 0 else {
            val b = Int.SIZE_BITS - x.countLeadingZeroBits() - 1
            val v = 1 shl b
            val res = (b-1) * b * v shr 2
            res + mul(x-v) + b * (x-v)
        }

        return intArrayOf()
    }
}

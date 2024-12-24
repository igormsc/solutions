class Solution2191 {
    fun sortJumbled(mapping: IntArray, nums: IntArray): IntArray {
        fun f(n: Int): Int {
            var res = 0
            var mul = 1
            var n = n
            if (n==0) res = mapping[0]
            while(n>0) {
                res +=mapping[n%10]*mul
                n /= 10
                mul *=10
            }
            return res
        }
        return nums.sortedWith(compareBy { f(it) }).toIntArray()
    }

}

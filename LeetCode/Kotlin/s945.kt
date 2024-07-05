class Solution945 {
    fun minIncrementForUnique(nums: IntArray): Int {
        nums.sort()
        return nums.fold(0 to 0) { (r, x), n -> (if (x-n>0) r+(x-n) else r) to if (n>x) n+1 else x+1 }.first
    }
}


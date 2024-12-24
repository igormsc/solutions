class Solution3315 {
    fun minBitwiseArray(nums: List<Int>): IntArray =
        nums.fold(mutableListOf<Int>()) { r, n -> r.add( if (n%2 ==0) -1 else n -((n+1).and(-n-1))/2 ); r}.toIntArray()
}

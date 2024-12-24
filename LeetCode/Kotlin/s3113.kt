import java.util.Stack

class Solution3113 {
    fun numberOfSubarrays(nums: IntArray): Long {
        val st = Stack<IntArray>();
        return nums.fold(0L) { r, n ->
                    while (st.isNotEmpty() && st.peek()[0] < n) st.pop()
                    if (st.isEmpty() || st.peek()[0] != n) st.push(intArrayOf(n, 0))
                    st.peek()[1]++
                    r + st.peek()[1].toLong()
        }
    }


}

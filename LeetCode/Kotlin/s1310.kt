class Solution1310 {
    fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
        val x = (1..arr.size).fold(IntArray(arr.size+1)) {r, i -> r[i] = r[i-1] xor arr[i-1]; r}
        return queries.fold(mutableListOf<Int>()) { r, q -> r.add(x[q[0]] xor x[q[1]+1]); r}.toIntArray()
    }
}
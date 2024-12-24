class Solution1460 {
    fun canBeEqual(target: IntArray, arr: IntArray): Boolean =
        target.indices
                .fold(IntArray(1001)) { r, i ->
                    r[target[i]]++
                    r[arr[i]]--
                    r}
                .find{ it > 0 } == null
}

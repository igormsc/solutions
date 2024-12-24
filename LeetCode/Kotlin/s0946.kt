class Solution946 {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        var (i, j) = 0 to 0
        pushed.forEach {
            pushed[i++] = it
            while (i>0 && pushed[i-1] == popped[j]) i--.also{j++}
        }
        return i == 0
    }
}

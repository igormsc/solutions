class Solution1346 {
    fun checkIfExist(arr: IntArray): Boolean {
        val s = mutableSetOf<Int>()
        for (n in arr) {
            if (s.contains(n*2) || (n%2 == 0 && s.contains(n/2))) return true
            s.add(n)
        }
        return false
    }
}


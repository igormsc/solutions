class Solution1700 {
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        val cnt = students.fold(IntArray(2)) { r, s -> r[s]++; r }
        var j = 0
        while (j < sandwiches.size && cnt[sandwiches[j]] > 0) cnt[sandwiches[j++]]--
        return students.size - j
    }

}


class Solution444 {
    fun sequenceReconstruction(nums: IntArray, sequences: List<List<Int>>): Boolean {
        val cnt = IntArray(nums.size)
        val g = Array(nums.size) { mutableListOf<Int>() }
        for (seq in sequences)
            for (i in 1..seq.lastIndex)
                (seq[i] - 1).also { g[seq[i - 1] - 1].add(it); cnt[it]++ }

        val q = mutableListOf<Int>()
        for (i in nums.indices)
            if (cnt[i] == 0) q.add(i)

        while (q.size == 1) {
            val i = q.removeFirst()
            for (j in g[i])
                if (--cnt[j] == 0) q.add(j)
        }
        return q.isEmpty()
    }

}
class Solution300 {
        fun lengthOfLIS(nums: IntArray): Int =
            nums.fold(Pair(0, IntArray(nums.size))){ r, n ->
                val m = fun(p: Pair<Int,Int>): Int = p.first + (p.second-p.first)/2
                val p = generateSequence(Pair(0, r.first)) { p ->
                    if (r.second[m(p)] < n) Pair(m(p)+1, p.second) else Pair(p.first, m(p))
                }.find{it.first == it.second}!!

                Pair(if (p.first+1 > r.first) p.first+1 else r.first,
                    r.second.also { r.second[p.first] = n })
            }.first
}

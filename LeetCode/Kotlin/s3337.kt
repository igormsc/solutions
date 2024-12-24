class Solution3337 {
    fun lengthAfterTransformations(s: String, t: Int, nums: List<Int>): Int {
        val MOD = 1_000_000_007
        val matrix = Array(26) { LongArray(26) }

        fun mult(m1: Array<LongArray>, m2: Array<LongArray>): Array<LongArray> {
            val res = Array(m1.size) { LongArray(m2.size) }
            (0..25).forEach { j ->
                (0..25).forEach { k ->
                    var i = 0
                    while (m2[k][j] != 0L && i<26) {
                        res[i][j] = (res[i][j] + m1[i][k] * m2[k][j]) % MOD
                        i++
                    }
                }
            }
            return res
        }

        fun pow(m: Array<LongArray>, p: Int): Array<LongArray> {
            if (p==1) return m
            var res = pow(m, p/2)
            res = mult(res,res)
            return if (p%2 != 0) mult(res,m) else res
        }

        val cnt = LongArray(26)
        nums.indices.forEach { i ->
            (0..<nums[i]).forEach { j ->
                matrix[i][(i+j+1)%26] = 1
            }
        }
        val mp = pow(matrix, t)
        (0..25).forEach { i ->
            cnt[i] = mp[i].fold(0L) { r, v -> (r+v)%MOD}
        }
        return s.fold(0L) { r, c -> (r + cnt[c.code-'a'.code])%MOD}.toInt()
    }


}

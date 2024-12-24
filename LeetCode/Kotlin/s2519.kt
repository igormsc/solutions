class Solution2519 {
    fun kBigIndices(nums: IntArray, k: Int): Int {
            val n = nums.size
            val tree1 = BinaryIndexedTree(n)
            val tree2 = BinaryIndexedTree(n)
            for (v in nums)
                tree2.update(v, 1)

            var res = 0
            for (v in nums) {
                tree2.update(v, -1)
                if (tree1.query(v - 1) >= k && tree2.query(v - 1) >= k) res++
                tree1.update(v, 1)
            }
            return res
        }

        internal class BinaryIndexedTree(private val n: Int) {
            private val arr = IntArray(n + 1)

            fun update(x: Int, delta: Int) {
                var x = x
                while (x <= n) {
                    arr[x] += delta
                    x += x and -x
                }
            }

            fun query(x: Int): Int {
                var x = x
                var s = 0
                while (x > 0) {
                    s += arr[x]
                    x -= x and -x
                }
                return s
            }
        }

}
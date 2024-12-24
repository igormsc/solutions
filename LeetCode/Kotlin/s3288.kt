class Solution3288 {
        fun maxPathLength(coordinates: Array<IntArray>, k: Int): Int {
            val crd = coordinates[k]
            coordinates.sortWith { a: IntArray, b: IntArray -> if (a[0] != b[0]) a[0] - b[0] else b[1] - a[1] }
            val current = coordinates.withIndex().find{it.value.contentEquals(crd)}?.index?:-1
            val l = f(filter(coordinates.slice(0..current), crd, true))
            val r = f(filter(coordinates.slice(current + 1..coordinates.lastIndex), crd, false))
            return l + r + 1
        }

        private fun f(nums: List<IntArray>): Int {
            val dp = mutableListOf<Int>()
            for (p in nums) {
                val v = p[1]
                var idx = dp.binarySearch(v)
                if (idx < 0) {
                    idx = -(idx + 1)
                    if (idx == dp.size) dp.add(v)
                    else dp[idx] = v
                }
            }
            return dp.size
        }

        private fun filter(nums: List<IntArray>, crd: IntArray, isLeft: Boolean): List<IntArray> {
            val res = mutableListOf<IntArray>()
            for (coord in nums)
                if (isLeft) {if (coord[0] < crd[0] && coord[1] < crd[1]) res.add(coord) }
                else if (coord[0] > crd[0] && coord[1] > crd[1]) res.add(coord)
            return res
        }

    }

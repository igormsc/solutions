class Solution1183 {
    fun maximumNumberOfOnes(width: Int, height: Int, sideLength: Int, maxOnes: Int): Int {
        val cnt = IntArray(sideLength * sideLength)
        for (i in 0..<width)
            for (j in 0..<height) {
                val k = (i % sideLength) * sideLength + (j % sideLength)
                cnt[k]++
            }
        cnt.sort()
        return (0..<maxOnes).sumOf { cnt[cnt.size - it - 1] }
    }

}
class Solution733 {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        fun fill(sr: Int, sc: Int, color: Int, newColor: Int) {
            if (sr !in 0..image.lastIndex || sc !in 0..image[0].lastIndex || image[sr][sc] != color) return
            image[sr][sc] = newColor
            fill(sr + 1, sc, color, newColor)
            fill(sr - 1, sc, color, newColor)
            fill(sr, sc + 1, color, newColor)
            fill(sr, sc - 1, color, newColor)
        }
        if (image[sr][sc] == color) return image
        fill(sr,sc,image[sr][sc],color)
        return image
    }
}

class Solution011 {
        fun maxArea(height: IntArray): Int =
            generateSequence(0 to height.lastIndex) { if (height[it.first]>height[it.second]) it.first to it.second-1 else it.first+1 to it.second }
                .takeWhile { it.first < it.second }
                .fold(0) { r, p  ->  maxOf(r, minOf(height[p.first], height[p.second]) * (p.second - p.first))}
    }

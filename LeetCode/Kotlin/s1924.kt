import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.random.Random

class Solution1924 {
        fun outerTrees(trees: Array<IntArray>): DoubleArray {

            val tr = trees.map{ Point(it[0].toDouble(), it[1].toDouble()) }.toSet().toMutableList()
            tr.shuffle(Random(System.currentTimeMillis()))

            fun clc(i: Int, r: List<Point>): List<Double> {
                if (r.size == 3) {
                    val (p0, p1, p2) = r
                    val a = p0.x*(p1.y-p2.y) - p0.y*(p1.x-p2.x) + p1.x*p2.y - p2.x*p1.y
                    val b = (p0.x*p0.x + p0.y*p0.y)*(p2.y-p1.y) + (p1.x*p1.x + p1.y*p1.y)*(p0.y-p2.y) + (p2.x*p2.x+p2.y*p2.y)*(p1.y-p0.y)
                    val c = (p0.x*p0.x + p0.y*p0.y)*(p1.x-p2.x) + (p1.x*p1.x + p1.y*p1.y)*(p2.x-p0.x) + (p2.x*p2.x+p2.y*p2.y)*(p0.x-p1.x)
                    val d = (p0.x*p0.x + p0.y*p0.y)*(p2.x*p1.y-p1.x*p2.y) + (p1.x*p1.x+p1.y*p1.y)*(p0.x*p2.y-p2.x*p0.y) + (p2.x*p2.x+p2.y*p2.y)*(p1.x*p0.y-p0.x*p1.y)
                    return listOf(-b/(2*a), -c/(2*a), sqrt((b*b+c*c-4*a*d)/(4*a*a)))
                }
                if (i == tr.size)
                    when (r.size) {
                        0 -> return listOf(0.0, 0.0, 0.0)
                        1 -> return listOf(r[0].x, r[0].y, 0.0)
                        2 -> {
                                val (p0, p1) = r
                                return listOf((p0.x + p1.x) / 2,(p0.y + p1.y) / 2,sqrt((p0.x - p1.x).pow(2) + (p0.y - p1.y).pow(2)) / 2) }
                    }

                val (x,y,d) = clc(i+1, r)
                if ((tr[i].x-x).pow(2) + (tr[i].y-y).pow(2) < d.pow(2)) return listOf(x, y, d)
                return clc(i+1, r.toMutableList().also{it.add(tr[i])})
            }

            return clc(0, listOf()).toDoubleArray()
        }

        data class Point(val x: Double,val y: Double)
}

fun main() {
    val trees = arrayOf(intArrayOf(1,1), intArrayOf(2,2), intArrayOf(2,0), intArrayOf(2,4), intArrayOf(3,3), intArrayOf(4,2))
    println( "Output: [2.00000,2.00000,2.00000]")
    val sl = Solution1924()
    println(sl.outerTrees(trees).joinToString (" "))

}

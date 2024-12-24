class Solution1491 {
    fun average(salary: IntArray): Double = (salary.sumOf{it.toDouble()} - salary.minOf{it} - salary.maxOf{it}) / (salary.size-2).toDouble()

}

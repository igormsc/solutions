import kotlin.math.absoluteValue

class Solution2037 {
    fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
        seats.sort()
        students.sort()
        return seats.indices.sumOf{ (seats[it] - students[it]).absoluteValue }
    }
}

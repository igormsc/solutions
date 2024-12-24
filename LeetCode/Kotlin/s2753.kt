class Solution2753 {
    fun houseCount(street: Street, k: Int): Int {
        while (!street.isDoorOpen())
            street.moveRight()
        var res = 0
        for (i in 1..k) {
            street.moveRight()
            if (street.isDoorOpen()) {
                res = i
                street.closeDoor()
            }
        }
        return res
    }

}

abstract class Street(doors: IntArray) {
    abstract fun closeDoor()
    abstract fun isDoorOpen(): Boolean
    abstract fun moveRight()
}
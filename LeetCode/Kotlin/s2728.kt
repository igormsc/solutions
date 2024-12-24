class Solution2728 {
    fun houseCount(street: Street, k: Int): Int {
        repeat(k) {
            street.openDoor()
            street.moveLeft()
        }
        var res = 0
        while (street.isDoorOpen()) {
            res++
            street.closeDoor()
            street.moveLeft()
        }
        return res
    }

    abstract class Street(var openDoor: Boolean = false) {
        abstract fun moveLeft()
        abstract fun moveRight()
        abstract fun closeDoor()
        abstract fun isDoorOpen(): Boolean
        abstract fun openDoor()
    }

}
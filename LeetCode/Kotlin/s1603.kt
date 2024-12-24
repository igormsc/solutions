class ParkingSystem(big: Int, medium: Int, small: Int) {

    private val cnt = intArrayOf(big, medium, small)

    fun addCar(carType: Int): Boolean = cnt[carType-1]-- > 0

}

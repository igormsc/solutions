class Solution066 {
    fun plusOne(digits: IntArray): IntArray {
        if (digits.isEmpty()) return digits
        if (digits.last() < 9) {
            digits[digits.lastIndex]++
            return digits
        }
        var car = false
        for (i in digits.lastIndex downTo 0) {
            if (car && digits[i] < 9) {
                digits[i]++
                car = false
                break
            } else if (digits[i] == 9) {
                car = true
                digits[i] = 0
            }
        }
        return if (car) digits.toMutableList().also{it.add(0, 1)}.toIntArray() else digits
    }
}
class Solution881 {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sortDescending()
        var i = 0
        var j = people.lastIndex
        while (i<=j) {
            if (people[i] + people[j] <= limit) j--
            i++
        }
        return i
    }
}

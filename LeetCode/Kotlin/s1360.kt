import java.time.LocalDate
import java.time.Duration
import kotlin.math.absoluteValue

class Solution1360 {
    fun daysBetweenDates(date1: String, date2: String): Int = Duration.between(LocalDate.parse(date1).atStartOfDay(), LocalDate.parse(date2).atStartOfDay()).toDays().toInt().absoluteValue
}

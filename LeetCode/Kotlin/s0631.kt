class Excel(height: Int, width: Char) {
    private var cells: Array<Array<CellValue?>> = Array(height) { arrayOfNulls(width.code - 'A'.code + 1) }

    fun set(row: Int, column: Char, `val`: Int) {
        cells[row - 1][column.code - 'A'.code] = StaticValue(`val`)
    }

    fun get(row: Int, column: Char): Int = if (cells[row - 1][column.code - 'A'.code] == null) 0 else cells[row - 1][column.code - 'A'.code]!!.intValue

    fun sum(row: Int, column: Char, numbers: Array<String>): Int {
        val v = Sum(this, numbers)
        cells[row - 1][column.code - 'A'.code] = v
        return v.intValue
    }

    internal abstract class CellValue {
        abstract val intValue: Int
    }

    internal class StaticValue(value: Int) : CellValue() {
        override var intValue: Int = value
    }

    internal class Sum(var e: Excel, var items: Array<String>) : CellValue() {
        override val intValue: Int
            get() {
                var sum = 0
                for (item in items) {
                    if (item.contains(":")) {
                        val p = item.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                        val (col1, row1) = p[0][0] to p[0].substring(1).toInt()
                        val (col2, row2) = p[1][0] to p[1].substring(1).toInt()
                        if (col2 >= col1 && row2 >= row1)
                            for (r in row1..row2) {
                                var c = col1
                                while (c <= col2)
                                    sum += e.get(r, c++)
                                }
                    } else sum += e.get(item.substring(1).toInt(), item[0])
                }
                return sum
            }
    }
}
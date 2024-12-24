class Solution294 {

    fun canWin(currentState: String): Boolean {
        val mm = mutableMapOf<Long, Boolean>()
        var mask = 0L
        for (i in currentState.indices)
            if (currentState[i] == '+') mask = mask or (1 shl i).toLong()

        fun dfs(mask: Long): Boolean {
            if (mm.containsKey(mask)) return mm[mask]!!
            for (i in 0..<currentState.lastIndex) {
                if ((mask and (1 shl i).toLong()) == 0L || (mask and (1 shl (i + 1)).toLong()) == 0L) continue
                if (dfs(mask xor (1 shl i).toLong() xor (1 shl (i + 1)).toLong())) continue
                mm[mask] = true
                return true
            }
            mm[mask] = false
            return false
        }

        return dfs(mask)
    }

}
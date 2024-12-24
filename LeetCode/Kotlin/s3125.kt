class Solution3125 {
      fun maxNumber(n: Long): Long = (1L.shl(63 - n.countLeadingZeroBits())) - 1

}
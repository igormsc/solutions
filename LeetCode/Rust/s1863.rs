struct Solution1863 {}

impl Solution1863 {
    pub fn subset_xor_sum(nums: Vec<i32>) -> i32 {
        (1..= 1<<nums.len()).fold(0,|r, i|{
            nums.iter().enumerate().fold(0, |x, (j,n)|{ if i & 1 << j == 0 {x} else {x^n} }) + r
        })
    }

}
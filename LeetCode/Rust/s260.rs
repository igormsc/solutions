struct Solution260 {}

impl Solution260 {
    pub fn single_number(nums: Vec<i32>) -> Vec<i32> {
        let x = nums.iter().fold(0, |r, n| r ^ *n);
        let x = x & -x;
        nums.iter().fold(vec![0, 0], |mut r, n| {
            r[if n & x == 0 { 0 } else { 1 }] ^= n;
            r
        })
    }
}
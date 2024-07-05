struct Solution3068 {}

impl Solution3068 {
    pub fn maximum_value_sum(nums: Vec<i32>, k: i32, edges: Vec<Vec<i32>>) -> i64 {
        let mut x = 0;
        let mut  y = 1 << 30;
        nums.iter().fold(0i64, |r, n|{
            let z = n ^ k;
            x = x ^ if *n<k {1} else {0};
            y = std::cmp::min(y, (*n-z).abs());
            r + std::cmp::max(*n, z) as i64
        }) - x as i64 * y as i64
    }
}
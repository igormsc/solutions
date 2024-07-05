use std::cmp::min;

struct Solution330 {}

impl Solution330 {
    pub fn min_patches(nums: Vec<i32>, n: i32) -> i32 {
        let n = n as i64;
        let mut sum = 0i64;
        let mut cnt = 0;
        let mut i = 0usize;
        while i<nums.len() || sum < n {
            let limit = if i<nums.len() {min(nums[i] as i64 - 1, n)} else {n};
            while sum<limit {
                sum += sum + 1;
                cnt +=1;
            }
            if i<nums.len() {sum += nums[i] as i64}
            i +=1;
        }
        cnt
    }
}
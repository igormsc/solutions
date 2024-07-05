struct Solution995 {}

impl Solution995 {
    pub fn min_k_bit_flips(nums: Vec<i32>, k: i32) -> i32 {
        let (mut r, mut f) = (0, 0);
        let mut nums = nums;
        let k = k as usize;
        for i in 0..nums.len() {
            if f%2 == nums[i] {
                if i > nums.len() - k { return -1 }
                nums[i] -= 2;
                r += 1;
                f += 1;
            }
            if i >= k-1 && nums[i-k+1] < 0 {
                nums[i-k+1] += 2;
                f -= 1;
            }
        }
        r
    }
}
struct Solution1509 {}

impl Solution1509 {
    pub fn min_difference(nums: Vec<i32>) -> i32 {
        let  n = nums.len();
        let mut nums = nums;
        nums.sort();
        let v = vec![nums[n - 1] - nums[3], nums[n - 2] - nums[2], nums[n - 3] - nums[1], nums[n - 4] - nums[0] ];
        *v.iter().min().unwrap()
    }
}
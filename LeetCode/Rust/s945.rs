struct Solution945 {}

impl Solution945 {
    pub fn min_increment_for_unique(nums: Vec<i32>) -> i32 {
        let mut nums = nums;
        nums.sort_unstable();
        nums.iter().fold((0,0),|(r,x), n|{ (if x-*n>0 {r+(x-*n)} else {r}, if *n>x {*n+1} else {x+1}) }).0
    }
}
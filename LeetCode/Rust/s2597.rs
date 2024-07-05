struct Solution2597 {}

impl Solution2597 {
    pub fn beautiful_subsets(nums: Vec<i32>, k: i32) -> i32 {
        Self::f(&nums, k, 0, 0)
    }

    fn f(nums: &Vec<i32>, k: i32, i: usize, mask: i32 ) -> i32 {
        if i==nums.len() {if mask>0 {1} else {0}}
        else { Self::f(nums, k, i+1, mask) +
            if (0..i).all(|j|{(1<<j)&mask==0 || (nums[j]-nums[i]).abs() !=k}) { Self::f(nums, k, i+1, mask+(1<<i))} else {0}
        }
    }
}
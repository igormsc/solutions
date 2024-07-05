struct Solution1438 {}

impl Solution1438 {
    pub fn longest_subarray(nums: Vec<i32>, limit: i32) -> i32 {
        use std::collections::VecDeque;
        let mut max_d: VecDeque<i32> = VecDeque::new();
        let mut min_d: VecDeque<i32> = VecDeque::new();
        let mut i = 0;
        for n in nums.iter() {
            while max_d.back().is_some_and(|x| *n > *x) { max_d.pop_back(); }
            while min_d.back().is_some_and(|x| *n < *x) { min_d.pop_back(); }
            max_d.push_back(*n);
            min_d.push_back(*n);
            if max_d[0] - min_d[0] > limit {
                if max_d[0] == nums[i] { max_d.pop_front(); }
                if min_d[0] == nums[i] { min_d.pop_front(); }
                i += 1;
            }
        }
        (nums.len() - i) as i32
    }
}

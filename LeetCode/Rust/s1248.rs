struct Solution1248 {}

impl Solution1248 {
    pub fn number_of_subarrays(nums: Vec<i32>, k: i32) -> i32 {
        use std::collections::VecDeque;
        let mut q: VecDeque<i32> = VecDeque::new();
        let k = (k + 1) as usize;
        q.resize(k, 0);
        q.push_back(-1);
        let mut r = 0;
        for i in 0..nums.len() {
            if nums[i] % 2 == 1 { q.push_back(i as i32) };
            if q.len() > k { q.pop_front(); }
            if q.len() == k { r += if q.len() > 1 { q[1] } else { i as i32 } - q[0] }
        };
        r
    }
}
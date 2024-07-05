
struct Solution523 {}

impl Solution523 {
    pub fn check_subarray_sum(nums: Vec<i32>, k: i32) -> bool {
        let mut m: std::collections::HashMap<i32, i32> = std::collections::HashMap::new();
        m.insert(0, -1);
        let mut cur = 0;
        !nums.iter().enumerate().find(|(i, n)| {
            let n = **n;
            let i = *i as i32;
            cur += n;
            if k != 0 { cur %= k };
            if m.contains_key(&cur) { i - m[&cur] > 1 } else { m.insert(cur, i); false }
        }).is_none()
    }
}
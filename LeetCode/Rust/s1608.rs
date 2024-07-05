struct Solution1608{}

impl Solution1608 {
    pub fn special_array(nums: Vec<i32>) -> i32 {
        let mut cnt = nums.iter().fold(vec![0;102],|mut r, n|{r[std::cmp::min(*n ,100) as usize] +=1; r});
        (1..101).rev().find(|i|{cnt[*i as usize] += cnt[*i as usize +1]; cnt[*i as usize] == *i}).unwrap_or(-1)
    }
}
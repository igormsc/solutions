struct Solution1051 {}

impl Solution1051 {
    pub fn height_checker(heights: Vec<i32>) -> i32 {
        let mut s = heights.clone();
        s.sort_unstable();
        (0..heights.len()).fold(0, |r, i|{ if heights[i] != s[i] {r+1} else {r} })
    }
}
struct Solution1404 {}

impl Solution1404 {
    pub fn num_steps(s: String) -> i32 {
        let mut c = 0;
        let s = s.as_bytes();
        (1..s.len()).rev().fold(0,|r, i|{
            r + if s[i] as i32 - '0' as i32 + c == 1 {c=1; 2} else {1} }) + c
    }
}
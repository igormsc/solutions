struct Solution1208 {}

impl Solution1208 {
    pub fn equal_substring(s: String, t: String, max_cost: i32) -> i32 {
        let s = s.as_bytes();
        let t = t.as_bytes();
        let mut j:usize = 0;
        (0..s.len()).fold(max_cost,|r, i|{
            let r = r - (s[i] as i32 - s[j] as i32).abs();
            if r<0 {let r = r + (s[j] as i32 - t[j] as i32).abs(); j +=1; r} else {r} });
        s.len() as i32 - j as i32
    }
}
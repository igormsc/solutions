struct Solution2486 {}

impl Solution2486 {
    pub fn append_characters(s: String, t: String) -> i32 {
        let mut j:usize = 0;
        let mut i:usize = 0;
        let s = s.as_bytes();
        let t = t.as_bytes();
        while i < s.len() && j < t.len() { if s[i] == t[j] {j+=1}; i +=1 }
        return (t.len() - j) as i32
    }
}
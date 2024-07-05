struct Solution344 {}

impl Solution344 {
    pub fn reverse_string(s: &mut Vec<char>) {
        let l = s.len() - 1;
        (0..=l/2).for_each(|i|{ (s[i], s[l-i]) = (s[l-i], s[i]) })
    }
}
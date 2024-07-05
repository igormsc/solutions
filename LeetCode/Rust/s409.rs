struct Solution409 {}

impl Solution409 {
    pub fn longest_palindrome(s: String) -> i32 {
        let r = s.as_bytes().iter().fold(vec![0;52], |mut r, c|{r[(*c - if *c <= 'Z' as u8 {'A' as u8} else {'a' as u8  - 26}) as usize]+=1;r})
            .iter().fold((0, false), |(ln,o), c |{(ln+*c/2, *c%2 == 1 || o)});
        r.0*2 + if r.1 {1} else {0}
    }
}
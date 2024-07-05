struct Solution131{}

impl Solution131 {
    pub fn partition(s: String) -> Vec<Vec<String>> {
        let mut pars: Vec<Vec<String>> = vec![];
        let mut par:Vec<String> = vec![];
        let s = s.as_bytes();
        Self::calc(s, 0, &mut par, &mut pars);
        return pars;
    }

    fn calc(s: &[u8], start: usize, par: &mut Vec<String>, pars: &mut Vec<Vec<String>>) -> () {
        let n = s.len();
        if start == n {pars.push(par.clone())}
        else {
            (start..n).for_each(|i|{
                if Self::is_palindrome(s.clone(), start, i) {
                    par.push(String::from_utf8(s[start..=i].to_owned()).unwrap());
                    Self::calc(s, i+1, par,  pars);
                    par.pop();
                }
            })
        }
    }

    fn is_palindrome(s: &[u8], mut l: usize, mut r: usize) -> bool {
        while l<r {
            if s[l] != s[r] {return false};
            l += 1;
            r -= 1;
        }
        return true
    }
}
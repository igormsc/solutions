struct Solution1550 {}

impl Solution1550 {
    pub fn three_consecutive_odds(arr: Vec<i32>) -> bool {
        let mut odds = 0;
        arr.iter().find(|n|{ if **n&1==1 { odds +=1} else {odds = 0}; odds == 3 }).is_some()
    }
}
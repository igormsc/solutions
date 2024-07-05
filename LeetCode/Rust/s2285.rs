struct Solution2285 {}

impl Solution2285 {
    pub fn maximum_importance(n: i32, roads: Vec<Vec<i32>>) -> i64 {
        let mut cnt = roads.iter().fold(vec![0;n as usize],
                                        | mut c, r |{ c[r[0] as usize] += 1; c[r[1] as usize] += 1; c });
        cnt.sort();
        (0..cnt.len()).fold(0i64,|r, i| { r + cnt[i] as i64 * (i+1) as i64 })
    }
}
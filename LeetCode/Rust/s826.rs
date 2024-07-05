struct Solution826 {}

impl Solution826 {
    pub fn max_profit_assignment(difficulty: Vec<i32>, profit: Vec<i32>, worker: Vec<i32>) -> i32 {
        let n = profit.len();
        let mut jobs: Vec<(i32, i32)> = difficulty.into_iter().zip(profit).collect();
        let mut worker = worker;
        worker.sort_unstable();
        jobs.sort_unstable_by(|a,b| (*a).0.cmp(&(*b).0));
        let mut i = 0usize;
        let mut best = 0;
        worker.iter().fold(0, |r, a| {
            while i < n && *a >= jobs[i].0 {
                best = std::cmp::max(best, jobs[i].1);
                i +=1;
            }
            r + best
        })
    }
}
struct Solution1482 {}

impl Solution1482 {
    pub fn min_days(bloom_day: Vec<i32>, m: i32, k: i32) -> i32 {
        let n = bloom_day.len();
        let mut l = 1;
        let mut r = 1_000_000_000;
        if m as i64 * k as i64 > n as i64 {return -1}
        while l<r {
            let mid = (l+r)/2;
            let mut flow = 0;
            let mut bq = 0;
            (0..n).for_each(|j| {
                if bloom_day[j]>mid {flow = 0} else {
                    flow +=1;
                    if flow >= k {
                        bq +=1;
                        flow = 0;
                    }
                }
            });
            if bq<m {l = mid+1} else {r = mid}
        }
        l
    }
}
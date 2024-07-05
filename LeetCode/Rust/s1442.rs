use std::collections::HashMap;

struct Solution1442 {}

impl Solution1442 {
    pub fn count_triplets(arr: Vec<i32>) -> i32 {
        use std::collections::HashMap;
        let mut res = 0;
        let mut pr = 0;
        let mut cnt = HashMap::from([(0, 1)]);
        let mut total: HashMap<i32, i32> = HashMap::new();
        arr.iter().enumerate().for_each(|(i, n)| {
            let i = i as i32;
            pr ^= n;
            res += cnt.get(&pr).unwrap_or(&0) * i - total.get(&pr).unwrap_or(&0);
            cnt.insert(pr, cnt.get(&pr).unwrap_or(&0) + 1);
            total.insert(pr, total.get(&pr).unwrap_or(&0) + i + 1);
        });
        res
    }
}
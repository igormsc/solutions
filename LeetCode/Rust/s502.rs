

struct Solution502 {}

impl Solution502 {
    pub fn find_maximized_capital(k: i32, w: i32, profits: Vec<i32>, capital: Vec<i32>) -> i32 {
        use std::collections::BinaryHeap;
        let mut projects: Vec<_> = profits.iter().enumerate().map(|(i, v)| { (*v, capital[i]) }).collect();
        projects.sort_by(|a,b|{((*a).0).cmp(&(*b).0)});
        let mut pq= BinaryHeap::new();
        let mut i = 0;
        let mut res = 0;
        (0..k).for_each(|_| {
            while i < profits.len() && projects[i].1 <= res {
                pq.push(projects[i].0);
                i += 1;
            }
            if !pq.is_empty() { res += pq.peek().unwrap()};
        });
        res
    }
}
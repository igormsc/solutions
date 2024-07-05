use std::collections::HashMap;

struct Solution350 {}

impl Solution350 {
    pub fn intersect(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        let mut m1 = nums1.iter().fold(HashMap::new(), |mut m: HashMap<i32,i32>, n| {
            match m.get_mut(n) {
                None => { m.insert(*n, 1); }
                Some(v) => { *v += 1 }
            }
            m });
        nums2.iter().fold(vec![], |mut r, n |{
            match m1.get_mut(n) {
                None => {   }
                Some(v) => {
                    *v -= 1;
                    if *v >= 0 { r.push(*n) }
                }
            }
            r
        })
    }
}
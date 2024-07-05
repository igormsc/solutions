struct Solution974 {}

impl Solution974 {
    pub fn subarrays_div_by_k(nums: Vec<i32>, k: i32) -> i32 {
        let mut cnt = vec![0; k as usize];
        cnt[0] = 1;
        let mut res = 0;
        let mut pref= 0;
        nums.iter().for_each(|n|{
            pref = (pref + *n % k + k ) % k ;
            let  x = &mut cnt[pref as usize] ;
            res += *x;
            *x +=1;
        });
        res
    }
}
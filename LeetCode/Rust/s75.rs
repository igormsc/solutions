struct Solution75 {}

impl Solution75 {
    pub fn sort_colors(nums: &mut Vec<i32>) {
        let mut i = 0;
        let mut j:usize = 0;
        let mut k = nums.len() as i32 -1;
        while j as i32 <=k {
            if nums[j] == 0 { nums.swap(i,j); i+=1; j+=1;}
            else { if nums[j] == 1 {j+=1;} else { nums.swap(k as usize,j); k-=1; }}
        }
    }
}
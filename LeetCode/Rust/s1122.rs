struct Solution1122 {}

impl Solution1122 {
    pub fn relative_sort_array(arr1: Vec<i32>, arr2: Vec<i32>) -> Vec<i32> {
        let mut arr1 = arr1;
        let mut cnt = arr1.iter().fold(vec![0, 1001], |mut r, n| {
            r[*n as usize] += 1;
            r
        });
        let mut i = -1;
        arr2.iter().for_each(|n| {
            while cnt[*n as usize] > 0 {
                i += 1;
                arr1[i as usize] = *n;
                cnt[*n as usize] -= 1;
            }
        });
        (0..cnt.len()).for_each(|j| {
            while cnt[j] > 0 {
                i += 1;
                arr1[i as usize] = j as i32;
                cnt[j] -= 1;
            }
        });
        arr1
    }
}
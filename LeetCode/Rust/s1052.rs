struct Solution1052 {}

impl Solution1052 {
    pub fn max_satisfied(customers: Vec<i32>, grumpy: Vec<i32>, minutes: i32) -> i32 {
        let (mut l, mut r) = (0, 0);
        let (mut satisfied, mut unsatisfied, mut max_unsatisfied) = (0, 0, 0);
        while r<grumpy.len() {
            if grumpy[r] != 0 { unsatisfied += customers[r] } else { satisfied += customers[r] }
            r += 1;
            if r-l>minutes as usize { if grumpy[l] != 0 {unsatisfied -= customers[l]}; l +=1; }
            if unsatisfied > max_unsatisfied { max_unsatisfied = unsatisfied }
        }
        satisfied + max_unsatisfied
    }

}
struct Solution78 {}

impl Solution78 {
    pub fn subsets(nums: Vec<i32>) -> Vec<Vec<i32>> {
        let mut res: Vec<Vec<i32>> = vec![];
        Self::sets(0, &nums, vec![], &mut res);
        res
    }

    fn sets(i: usize, nums: &Vec<i32>, mut sub: Vec<i32>, res: &mut Vec<Vec<i32>>) -> () {
        res.push(sub.clone());
        (i..nums.len()).for_each(|j|{
            sub.push(nums[j]);
            Self::sets(j+1, nums, sub.clone(), res);
            sub.pop();
        })
    }

}
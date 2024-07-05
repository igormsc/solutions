// Definition for a binary tree node.
#[derive(Debug, PartialEq, Eq)]
pub struct TreeNode {
    pub val: i32,
    pub left: Option<Rc<RefCell<TreeNode>>>,
    pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
    #[inline]
    pub fn new(val: i32) -> Self {
        TreeNode {
            val,
            left: None,
            right: None,
        }
    }
}

struct Solution929 {}

use std::rc::Rc;
use std::cell::RefCell;


impl Solution929 {
    pub fn distribute_coins(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        let mut res = 0;
        Self::dfs(root, &mut res);
        res
    }

    fn dfs(root: Option<Rc<RefCell<TreeNode>>>, res: &mut i32) -> i32 {
        if root.is_none() { 0 } else {
            let n = root.unwrap();
            let n = n.borrow();
            let left = Self::dfs(n.left.clone(), res);
            let right = Self::dfs(n.right.clone(), res);
            *res += left.abs() + right.abs();
            n.val + left + right - 1
        }
    }
}
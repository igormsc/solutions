use std::rc::Rc;
use std::cell::RefCell;

struct Solution1038 {}

// Definition for a binary tree node.
#[derive(Debug, PartialEq, Eq)]
pub struct TreeNode {
  pub val: i32,
  pub left: Option<Rc<RefCell<TreeNode>>>,
  pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl Solution1038 {
    pub fn bst_to_gst(root: Option<Rc<RefCell<TreeNode>>>) -> Option<Rc<RefCell<TreeNode>>> {
        let mut pre = 0;
        Self::bst(root, &mut pre)
    }

    fn bst(n: Option<Rc<RefCell<TreeNode>>>, pre: &mut i32) -> Option<Rc<RefCell<TreeNode>>> {
        let n = n?;
        let mut rn = n.borrow_mut();
        rn.right = Self::bst(rn.right.take(), pre);
        rn.val += *pre;
        *pre = rn.val;
        rn.left = Self::bst(rn.left.take(), pre);
        drop(rn);
        Some(n)
    }

}


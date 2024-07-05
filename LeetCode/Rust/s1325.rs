use std::rc::Rc;
use std::cell::RefCell;

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
      right: None
    }
  }
}

struct Solution1325 {}

impl Solution1325 {
    pub fn remove_leaf_nodes(root: Option<Rc<RefCell<TreeNode>>>, target: i32) -> Option<Rc<RefCell<TreeNode>>> {
        Self::postOrderTraversal(root, target)
    }

    fn postOrderTraversal(root: Option<Rc<RefCell<TreeNode>>>, target: i32) -> Option<Rc<RefCell<TreeNode>>> {
        if root.is_none() { None }
        else {
            let mut n = root.to_owned().unwrap();
            let mut n = n.borrow_mut();
            n.left = Self::postOrderTraversal(n.left.take(), target);
            n.right = Self::postOrderTraversal(n.right.take(), target);
            if n.left == n.right && n.val == target { None } else { drop(n); root }
        }
    }
}
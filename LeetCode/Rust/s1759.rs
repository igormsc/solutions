struct Solution1759 {}

impl Solution1759 {
    pub fn max_num_edges_to_remove(n: i32, edges: Vec<Vec<i32>>) -> i32 {
        let mut ds_both = vec![-1; n as usize+1];
        let mut ds_both_copy = vec![-1; n as usize+1];
        let mut used = 0;
        for tp in (1..=3).rev() {
            let mut ds: &mut Vec<i32> = if tp == 3 { &mut ds_both } else { &mut ds_both_copy };
            for e in edges.iter(){
                if e[0] == tp {
                    let (i, j) = (Self::find(ds, e[1]), Self::find(ds, e[2]));
                    if i != j {
                        used += 1;
                        let (i, j) = (i as usize, j as usize);
                        let (i,j ) = if ds[j] < ds[i] { (j,i) } else { (i,j) };
                        ds[i] += ds[j];
                        ds[j] = i as i32;
                    }
                }
            };
            if tp != 3 { let f = Self::find(ds, 1); if ds[f as usize] != -n {return -1 } };
        };
        edges.len() as i32 - used
    }

    fn find(ds: &mut Vec<i32>, i: i32) -> i32 {
        let i = i as usize;
        if ds[i] < 0 { i as i32 } else {
            ds[i] = Self::find(ds, ds[i]);
            ds[i]
        }
    }

}
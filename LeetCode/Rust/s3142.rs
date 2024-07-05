struct Solution3142 {}

impl Solution3142 {
    pub fn satisfies_conditions(grid: Vec<Vec<i32>>) -> bool {
        grid.iter().enumerate().find(|(i,row)| {
            !(*row).iter().enumerate().find(|(j,v)|{
                (*j < (**row).len()-1 && **v == grid[*i][*j+1]) || (*i < grid.len()-1 && **v != grid[*i+1][*j])
            }).is_none()
        }).is_none()
    }
}
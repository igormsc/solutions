struct Solution633 {}

impl Solution633 {
    pub fn judge_square_sum(c: i32) -> bool {
        let mut f = 2;
        let mut c = c;
        while f*f <= c {
            let mut ex = 0;
            if c%f == 0 {
                while c%f == 0 {
                    ex +=1;
                    c /= f;
                }
                if f%4 == 3 && ex%2 != 0 {return false}
            }
            f +=1;
        }
        c%4 != 3
    }
}
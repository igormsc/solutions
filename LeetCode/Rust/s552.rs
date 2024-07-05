struct Solution552 {}

impl Solution552 {
    pub fn check_record(n: i32) -> i32 {
        let MOD = 1_000_000_007;
        let n = n as usize;

        if n==1 {return 3}

        let mut a = vec![0;if n<3 {3} else {n}];
        a[0] = 1; a[1] = 2; a[2] = 4;
        let mut p = vec![0; if n<2 {2} else {n}];
        p[0] = 1;
        let mut l = vec![0; if n<1 {1} else {n}];
        l[0] = 1; l[1] = 3;

        (1..n).for_each(|i|{
            p[i] = ((a[i-1]+p[i-1])%MOD + l[i-1]) % MOD;
            if i > 1 {l[i] = ((a[i-1]+p[i-1])%MOD + (a[i-2]+p[i-2])%MOD) % MOD}
            if i > 2 {a[i] = ((a[i-1]+a[i-2])%MOD + a[i-3]) % MOD}
        });

        return ((a[n-1]+p[n-1])%MOD + l[n-1]%MOD)%MOD
    }
}
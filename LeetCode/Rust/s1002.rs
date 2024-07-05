struct Solution1002 {}

impl Solution1002 {
    pub fn common_chars(words: Vec<String>) -> Vec<String> {
        let mut cnt = vec![10_000_000;26];
        words.iter().for_each(|w|{
            let cnt1 = w.as_bytes().iter().fold(vec![0;26],|mut r, c|{r[(*c - 'a' as u8) as usize] +=1; r});
            (0..cnt.len()).for_each(|i| if cnt[i]>cnt1[i] {cnt[i]=cnt1[i]});

        });
        cnt.iter().enumerate().fold(vec![],|mut r,(i,c)|{(0..*c).for_each(|_| r.push(String::from(('a' as u8 + i as u8) as char))); r})
    }
}
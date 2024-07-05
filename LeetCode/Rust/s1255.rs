struct Solution1255 {}

impl Solution1255 {
    pub fn max_score_words(words: Vec<String>, letters: Vec<char>, score: Vec<i32>) -> i32 {
        if words.is_empty() || letters.is_empty() || score.is_empty() {return 0}
        let mut cnt = letters.iter().fold(vec![0;score.len()], |mut r , l| { r[*l as usize - 'a' as usize] += 1; r });

        struct BACKTRACK<'s> {f: &'s dyn Fn(&BACKTRACK, usize, &mut Vec<i32>) -> i32};
        let backtrack = BACKTRACK{f: &|backtrack, index, cnt| {
            (index..words.len()).fold(0,|mx, i|{
                let mut is_valid = true;
                let sum: i32 = words[i].as_bytes().iter().fold(0,|r, c|{
                    cnt[*c as usize - 'a' as usize] -=1;
                    if cnt[*c as usize - 'a' as usize] < 0 {is_valid = false};
                    r + score[*c as usize - 'a' as usize] });
                let r = std::cmp::max(if is_valid {sum + (backtrack.f)(&backtrack, i+1, cnt)} else {mx}, mx);
                words[i].as_bytes().iter().for_each(|c|{cnt[*c as usize - 'a' as usize] +=1; });
                r })
        }};
        return  (backtrack.f)(&backtrack, 0, &mut cnt)
    }

}
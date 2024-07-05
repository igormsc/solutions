struct Solution846 {}

impl Solution846 {
    pub fn is_n_straight_hand(hand: Vec<i32>, group_size: i32) -> bool {
        let mut hand = hand;
        hand.sort();
        let mut groups = vec![vec![0;2];hand.len()/group_size as usize];
        for i in 0..hand.len() {
            for j in 0..=groups.len() {
                if j == groups.len() {return false};
                if groups[j][1] == 0 || (groups[j][1] < group_size && groups[j][0] == hand[i]-1) {
                    groups[j][0] = hand[i];
                    groups[j][1] +=1;
                    break
                }
            }
        }
        true
    }
}
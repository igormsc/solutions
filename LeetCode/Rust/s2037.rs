struct Solution2037 {}

impl Solution2037 {
    pub fn min_moves_to_seat(seats: Vec<i32>, students: Vec<i32>) -> i32 {
        let mut seats = seats;
        seats.sort_unstable();
        let mut students = students;
        students.sort_unstable();
        (0..seats.len()).fold(0,|r, i|{ r + (seats[i]-students[i]).abs() })
    }
}
use std::io::{stdin};

fn main() {
    let mut input = String::new();
    stdin().read_line(&mut input).unwrap();
    let n = input.trim().parse::<usize>().unwrap();
    for _ in 0..n {
        input.clear();
        stdin().read_line(&mut input).unwrap();
        let height: Vec<usize> = input.split_whitespace()
                                  .map(|s| s.parse().unwrap())
                                  .collect();
        let mut arr: Vec<usize> = Vec::new();
        let mut mv: usize = 0;
        for i in 1..21 {
            arr.push(height[i]);
            arr.sort();
            mv = mv + (arr.len() - arr.partition_point(|x| x <= &height[i]));
        }
        println!("{} {}", height[0], mv);
    }
}

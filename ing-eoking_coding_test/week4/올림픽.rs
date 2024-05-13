use std::io::{stdin};

fn main() {
    let mut input = String::new();
    stdin().read_line(&mut input).unwrap();
    let mut rank: Vec<u64> = Vec::new();
    let mut find_score: u64 = 0;
    let nm: Vec<u64> = input.split_whitespace()
                            .map(|s| s.parse().unwrap())
                            .collect();
    for _ in 0..nm[0] {
        input.clear();
        stdin().read_line(&mut input).unwrap();
        let info: Vec<u64> = input.split_whitespace()
                                  .map(|s| s.parse().unwrap())
                                  .collect();
        let score = info[1] * 1000000000000 
                  + info[2] * 1000000
                  + info[3];
        if info[0] == nm[1] { find_score = score; }
        rank.push(score);
    }
    rank.sort();
    rank.reverse();
    let answer = rank.partition_point(|x| x > &find_score);
    println!("{}", answer + 1);
}

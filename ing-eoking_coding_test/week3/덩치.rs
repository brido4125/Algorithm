use std::io::{stdin, Read};
use std::fmt::Write;

fn main() {
    let mut input = String::new();
    let mut output = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();
    let mut arr: [[u32; 2]; 50] = [[0; 2]; 50];
    for i in 0..n {
        arr[i][0] = input.next().unwrap().parse::<u32>().unwrap();
        arr[i][1] = input.next().unwrap().parse::<u32>().unwrap();
    }
    for i in 0..n {
        let mut rank = 0;
        for j in 0..n {
            if arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1] { rank += 1; }
        }
        write!(output, "{} ", rank + 1).unwrap();
    }
    println!("{}", output);
}

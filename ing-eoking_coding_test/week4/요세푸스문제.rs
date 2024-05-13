use std::io::{stdin};
use std::fmt::Write;
use std::collections::VecDeque;

fn main() {
    let mut input = String::new();
    let mut output = String::new();
    stdin().read_line(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();
    let n = input.next().unwrap().parse::<usize>().unwrap();
    let k = input.next().unwrap().parse::<usize>().unwrap();
    let mut que: VecDeque<usize> = (1..n+1).collect();
    let mut answer: Vec<usize> = Vec::new();
    for _ in 0..n {
        for _ in 0..k-1 { 
            let num = que.pop_front().unwrap();
            que.push_back(num);
        }
        answer.push(que.pop_front().unwrap());
    }
    write!(output, "{:?}", answer).unwrap();
    output = output.replace("[", "<");
    output = output.replace("]", ">");
    println!("{}", output);
}

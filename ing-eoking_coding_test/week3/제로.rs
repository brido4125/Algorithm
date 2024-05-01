use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();
    let mut stack = Vec::new();
    let mut sum = 0;
    for _ in 0..n {
        let e = input.next().unwrap().parse::<u32>().unwrap();
        if e == 0 { sum -= stack.pop().unwrap(); }
        else { sum += e; stack.push(e); }
    }
    println!("{}", sum);
}

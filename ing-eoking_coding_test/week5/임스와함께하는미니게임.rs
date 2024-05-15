use std::io::{stdin, Read};
use std::collections::HashSet;

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();
    let kind = input.next().unwrap().parse::<char>().unwrap();
    let mut challengers = HashSet::new();
    let need = if kind == 'Y' { 1 }
               else if kind == 'F' { 2 }
               else { 3 };
    for _ in 0..n {
        challengers.insert(input.next().unwrap());
    }
    println!("{}", challengers.len() / need);
}

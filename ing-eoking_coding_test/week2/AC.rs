use std::io::{stdin, Read};
use std::fmt::Write;
use std::collections::VecDeque;

fn main() {
    let mut input = String::new();
    let mut output = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let t = input.next().unwrap().parse::<usize>().unwrap();
    for _ in 0..t {
        let p = input.next().unwrap().chars().collect::<Vec<char>>();
        let n = input.next().unwrap().parse::<usize>().unwrap();
        let mut x = input.next().unwrap();
        x = &x[1..x.len()-1];
        let mut x:VecDeque<usize> = if n > 0 {
            x.split(",")
             .map(|i| i.trim().parse().expect("error"))
             .collect::<VecDeque<_>>()
        } else {
            VecDeque::new()
        };
        let mut reverse = false;
        let mut error = false;
        for i in &p {
            if *i == 'R' { reverse = !reverse; }
            else if *i == 'D' {
                if x.is_empty() { error = true; break; }
                else if reverse { x.pop_back(); }
                else { x.pop_front(); }
            }
        }
        if error { writeln!(output, "error").unwrap(); }
        else {
            write!(output, "[").unwrap();
            for i in 0..x.len() {
                if i != 0 { write!(output, ",").unwrap(); }
                if reverse { write!(output, "{}", x[x.len() - i - 1]).unwrap(); }
                else { write!(output, "{}", x[i]).unwrap(); }
            }
            writeln!(output, "]").unwrap();
        }
    }
    println!("{}", output);
}

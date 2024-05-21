use std::io::{stdin};

fn main() {
    loop {
        let mut input = String::new();
        stdin().read_line(&mut input).unwrap();
        input = input.replace("\n", "");
        if input == "end" { break; }
        println!("<{}> is {}acceptable.", input, is_accept(input.clone()));
    }
}

fn is_accept(msg: String) -> &'static str {
    let mut vow :i32 = 0;
    let mut cons :i32 = 0;
    let mut has_vow = "not ";
    let mut prev = '.';
    for s in msg.chars() {
        if ['a','e','i','o','u'].contains(&s) { vow += 1; cons = 0; has_vow = ""; }
        else { vow = 0; cons += 1; }
        if vow > 2 || cons > 2 { return "not "; }
        if s != 'e' && s != 'o' && s == prev { return "not "; }
        prev = s;
    }
    return has_vow;
}

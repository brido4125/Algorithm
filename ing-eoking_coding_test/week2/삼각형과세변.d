import std;

void main()
{
    string line;
    while ((line = readln()) !is null) {
        int[] num = to!(int[])(line.strip.split);
        num.sort();
        if (num[2] == 0) break;
        if (num[0] == num[2]) writeln("Equilateral");
        else if (num[0] + num[1] <= num[2]) writeln("Invalid");
        else if (num[0] == num[1] || num[1] == num[2]) writeln("Isosceles");
        else writeln("Scalene");
    }
}

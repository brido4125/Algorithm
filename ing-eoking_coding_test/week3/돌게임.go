package main

import "fmt"

func main() {
    name := []string{"CY", "SK"}
    var stone int
    fmt.Scanf("%d", &stone);
    fmt.Println(name[stone % 2])
}

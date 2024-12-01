package main

import (
	_ "embed"
	"strings"
)

//go:embed input.txt
var input string


func main() {

	input = strings.Trim(input, "\n")
	if len(input) == 0 {
		panic("empty input.txt file")
	}
	println("Part1 =",part1())
	println("Part2 =",part2())
}

func part1() int {
	return 0
}
func part2() int {
	return 0
}
package main

import (
	_ "embed"
	"fmt"
	"regexp"
	"strconv"
	"strings"
)

//go:embed input.txt
var input string

func main() {
	input = strings.Trim(input, "\n")
	if len(input) == 0 {
		panic("empty input.txt file")
	}
	fmt.Println("Part1 =", part1())
	fmt.Println("Part2 =", part2())
}

func part1() int {
	result := 0
	for _, line := range strings.Split(input, "\n") {
		re := regexp.MustCompile(`mul\(\d+,\d+\)`)
        matches := re.FindAllString(line, -1)

		for _, match := range matches {
		result = addNumbers(match, result)
		}
	}
	return result
}

func part2() int {
	result := 0
	enableMul := true
	for _, line := range strings.Split(input, "\n") {
		re := regexp.MustCompile(`do\(\)|don't\(\)|mul\(\d+,\d+\)`)
		matches := re.FindAllString(line, -1)

		for _, match := range matches {
			if match == "do()" {
				enableMul = true
				continue
			}
			if match == "don't()" {
				enableMul = false
				continue
			}
			if enableMul {
				result = addNumbers(match, result)
			}
		}
	}
	return result
}

func addNumbers(match string, result int) int {
    parts := strings.Split(match[4:len(match)-1], ",")
    num1, _ := strconv.Atoi(parts[0])
    num2, _ := strconv.Atoi(parts[1])
    return result + num1*num2
}
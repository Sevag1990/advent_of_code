package main

import (
	_ "embed"
	"fmt"
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
	safeReports := 0

	for _, line := range strings.Split(input, "\n") {
		level := parseLineToInts(line)
		if isSafeReport(level) {
			safeReports++
		}
	}

	return safeReports
}

func part2() int {
	safeReports := 0

	for _, line := range strings.Split(input, "\n") {
		level := parseLineToInts(line)
		if isSafeReport(level) {
			safeReports++
			continue
		}
		for i := 0; i < len(level); i++ {
			newLevel := append([]int{}, level[:i]...)
			newLevel = append(newLevel, level[i+1:]...)
			if isSafeReport(newLevel) {
				safeReports++
				break
			}
		}
	}

	return safeReports
}

func isSafeReport(parts []int) bool {
	increasing := false
	decreasing := false

	for i := 0; i < len(parts)-1; i++ {
		num1 := parts[i]
		num2 := parts[i+1]

		if num1 == num2 {
			return false
		}

		if num1 > num2 {
			decreasing = true
		} else if num1 < num2 {
			increasing = true
		}

		if abs(num1-num2) > 3 {
			return false
		}
	}
	if increasing && decreasing {
		return false
	}
	return true
}

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}

func parseLineToInts(line string) []int {
    fields := strings.Fields(line)
    ints := make([]int, len(fields))
    for i, field := range fields {
        num, err := strconv.Atoi(field)
        if err != nil {
            panic("invalid number format")
        }
        ints[i] = num
    }
    return ints
}
package main

import (
	_ "embed"
	"math"
	"sort"
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
	println("Part1 =",part1())
	println("Part2 =",part2())
}

func part1() int {
	var leftList, rightList []int
	result  := 0

	for _, line := range strings.Split(input, "\n") {
		parts := strings.Fields(line)

		num1, err1 := strconv.Atoi(parts[0])
		num2, err2 := strconv.Atoi(parts[1])

		if err1 != nil || err2 != nil {
			panic("invalid number format")
		}
		rightList = append(rightList, num1)
		sort.Ints(rightList)

		leftList = append(leftList, num2)
		sort.Ints(leftList)
	}
	for i := 0; i < len(rightList); i++ {
		result += int(math.Abs(float64(rightList[i] - leftList[i])))
	}
	return result
}
func part2() int {
	var leftList, rightList []int
	result  := 0

	for _, line := range strings.Split(input, "\n") {
		parts := strings.Fields(line)

		num1, err1 := strconv.Atoi(parts[0])
		num2, err2 := strconv.Atoi(parts[1])

		if err1 != nil || err2 != nil {
			panic("invalid number format")
		}
		rightList = append(rightList, num1)
		leftList = append(leftList, num2)
	}

	for i := 0; i < len(rightList); i++ {
		similarity := 0
		for j := 0; j < len(leftList); j++ {
			if rightList[i] == leftList[j] {
				similarity++
			}
		}
		result += rightList[i] * similarity
	}
	return result
}
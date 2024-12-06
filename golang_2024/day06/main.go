package main

import (
	_ "embed"
	"fmt"
	"strings"
)

//go:embed input.txt
var input string

func main() {
    fmt.Println("Part1 =", part1())
}

func part1() int {
    matrix := convertIntoMatrix(input)
    startPosition := findStartPosition(matrix)
    direction := "up"
    return traverseMatrix(matrix, startPosition, direction)
}

func traverseMatrix(matrix [][]string, startPosition []int, direction string) int {
    row, column := startPosition[0], startPosition[1]
    visited := make(map[[2]int]bool)

    for {
        if !visited[[2]int{row, column}] {
            visited[[2]int{row, column}] = true
        }
        fmt.Println(row, column, "direction:", direction)

        switch direction {
        case "up":
            if row > 0 && matrix[row-1][column] == "." {
                row--
            } else if row > 0 && matrix[row-1][column] == "#" {
                column++
                direction = "right"
            } else {
                return len(visited)
            }
        case "right":
            if column < len(matrix[row])-1 && matrix[row][column+1] == "." {
                column++
            } else if column < len(matrix[row])-1 && matrix[row][column+1] == "#" {
                row++
                direction = "down"
            } else {
                return len(visited)
            }
        case "down":
            if row < len(matrix)-1 && matrix[row+1][column] == "." {
                row++
            } else if row < len(matrix)-1 && matrix[row+1][column] == "#" {
                column--
                direction = "left"
            } else {
                return len(visited)
            }
        case "left":
            if column > 0 && matrix[row][column-1] == "." {
                column--
            } else if column > 0 && matrix[row][column-1] == "#" {
                row--
                direction = "up"
            } else {
                return len(visited)
            }
        }
    }
}

func findStartPosition(matrix [][]string) []int {
    for i := 0; i < len(matrix); i++ {
        for j := 0; j < len(matrix[i]); j++ {
            if matrix[i][j] == "^" {
                matrix[i][j] = "."
                return []int{i, j}
            }
        }
    }
    return []int{0, 0}
}

func convertIntoMatrix(input string) [][]string {
    lines := strings.Split(strings.TrimSpace(input), "\n")
    matrix := make([][]string, len(lines))

    for i := 0; i < len(lines); i++ {
        matrix[i] = strings.Split(lines[i], "")
    }

    return matrix
}
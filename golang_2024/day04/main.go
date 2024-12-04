package main

import (
	_ "embed"
	"fmt"
	"strings"
)

//go:embed example.txt
var input string

func main() {
    fmt.Println("Part1 =", part1())
    // fmt.Println("Part2 =", part2())
}

func part1() int {
    result := 0
    matrix := convertIntoMatrix()
    for i := 0; i < len(matrix); i++ {
        for j := 0; j < len(matrix[i]); j++ {
            if matrix[i][j] == "X" {
                result += search(matrix, i, j) 
            }
        }
    }
    return result
}

// func part2() int {
//     result := 0
//     matrix := convertIntoMatrix()
//     for x := 0; x < len(matrix); x++ {
//         for y := 0; y < len(matrix[x]); y++ {
//             if matrix[x][y] == "A" {
            
//                 // upRight
//                 if x-3 >= 0 && y+3 < len(matrix[x]) &&  x+3 < len(matrix) && y+3 < len(matrix[x]) {
//                     if matrix[x-1][y+1] == "M" && matrix[x+2][y-2] == "S" {
//                         result++
//                     } 
//                     if matrix[x-1][y+1] == "S" && matrix[x+2][y-2] == "M" {
//                         result++
//                     }
//                 }
//                 // downRight
//                 if x+3 < len(matrix) && y+3 < len(matrix[x]) && x-3 >= 0 && y+3 < len(matrix[x]) {
//                     if matrix[x+1][y+1] == "M" && matrix[x-2][y-2] == "S" {
//                         result++
//                     }
//                     if matrix[x+1][y+1] == "S" && matrix[x-2][y-2] == "M" {
//                         result++
//                     }
//                 }

//                 // upLeft
//                 if x-3 >= 0 && y-3 >= 0 && x+3 < len(matrix) {
//                     if matrix[x-1][y-1] == "M" && matrix[x+2][y+2] == "S" {
//                         result++
//                     }
//                     if matrix[x-1][y-1] == "S" && matrix[x+2][y+2] == "M" {
//                         result++
//                     }
//                 }
//                 // downLeft
//                 if x+3 < len(matrix) && y-3 >= 0 {
//                     if matrix[x+1][y-1] == "M" && matrix[x-2][y+2] == "S" {
//                         result++
//                     }
//                     if matrix[x+1][y-1] == "S" && matrix[x-2][y+2] == "M" {
//                         result++
//                     }
//                 }
       
                    
//             }
//         }
//     }
//     return result
// }

func search(matrix [][]string, x int, y int) int {
    xmasCounter := 0
    if searchRight(matrix, x, y) {
        xmasCounter++
    }
    if searchLeft(matrix, x, y) {
        xmasCounter++
    }
    if searchUp(matrix, x, y) {
        xmasCounter++
    }
    if searchDown(matrix, x, y) {
        xmasCounter++
    }
    if searchUpRight(matrix, x, y) {
        xmasCounter++
    }
    if searchUpLeft(matrix, x, y) {
        xmasCounter++
    }
    if searchDownRight(matrix, x, y) {
        xmasCounter++
    }
    if searchDownLeft(matrix, x, y) {
        xmasCounter++
    }
    return xmasCounter 
}

func searchRight(matrix [][]string, x int, y int) bool {
    if y+3 < len(matrix[x]) && matrix[x][y+1] == "M" && matrix[x][y+2] == "A" && matrix[x][y+3] == "S" {
        fmt.Println("Right", x, y)
        return true
    }
    return false
}

func searchLeft(matrix [][]string, x int, y int) bool {
    if y-3 >= 0 && matrix[x][y-1] == "M" && matrix[x][y-2] == "A" && matrix[x][y-3] == "S" {
        fmt.Println("Left", x, y)
        return true
    }
    return false
}

func searchUp(matrix [][]string, x int, y int) bool {
    if x-3 >= 0 && matrix[x-1][y] == "M" && matrix[x-2][y] == "A" && matrix[x-3][y] == "S" {
        fmt.Println("Up", x, y)
        return true
    }
    return false
}

func searchDown(matrix [][]string, x int, y int) bool {
    if x+3 < len(matrix) && matrix[x+1][y] == "M" && matrix[x+2][y] == "A" && matrix[x+3][y] == "S" {
        fmt.Println("Down", x, y)
        return true
    }
    return false
}

func searchUpRight(matrix [][]string, x int, y int) bool {
    if x-3 >= 0 && y+3 < len(matrix[x]) && matrix[x-1][y+1] == "M" && matrix[x-2][y+2] == "A" && matrix[x-3][y+3] == "S" {
        fmt.Println("UpRight", x, y)
        return true
    }
    return false
}

func searchUpLeft(matrix [][]string, x int, y int) bool {
    if x-3 >= 0 && y-3 >= 0 && matrix[x-1][y-1] == "M" && matrix[x-2][y-2] == "A" && matrix[x-3][y-3] == "S" {
        fmt.Println("UpLeft", x, y)
        return true
    }
    return false
}

func searchDownRight(matrix [][]string, x int, y int) bool {
    if x+3 < len(matrix) && y+3 < len(matrix[x]) && matrix[x+1][y+1] == "M" && matrix[x+2][y+2] == "A" && matrix[x+3][y+3] == "S" {
        fmt.Println("DownRight", x, y)
        return true
    }
    return false
}

func searchDownLeft(matrix [][]string, x int, y int) bool {
    if x+3 < len(matrix) && y-3 >= 0 && matrix[x+1][y-1] == "M" && matrix[x+2][y-2] == "A" && matrix[x+3][y-3] == "S" {
        fmt.Println("DownLeft", x, y)
        return true
    }
    return false
}
func convertIntoMatrix() [][]string {
    words := strings.Split(input, "\n")
    var matrix = make([][]string, len(words))

    for i := 0; i < len(words); i++ {
        char := strings.Split(words[i], "")
        matrix[i] = append(matrix[i], char...)
    }

    return matrix
}

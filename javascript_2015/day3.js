runPart1();
runPart2();

function runPart1() {
    const fs = require("fs");
    const lines = fs
        .readFileSync("./javascript_2015/inputs/day3.txt", { encoding: "utf-8" })
        .split("")
        .map(line => line.trim());

    let grid = [0, 0];
    let visited = new Set();
    visited.add(`0x0`);


    for (let i = 0; i < lines.length; i++) {
        if (lines[i] == '^') {
                grid = [grid[0], grid[1] - 1];
        }

        if (lines[i] == 'v') {
                grid = [grid[0], grid[1] + 1];
        }
        if (lines[i] == '>') {
                grid = [grid[0] + 1, grid[1]];
        }
        if (lines[i] == '<') {
                grid = [grid[0] - 1, grid[1]];
        }

            visited.add(`${grid[0]}x${grid[1]}`);
    }
    console.log(`Part 1: ${visited.size}`);
}
function runPart2() {
    const fs = require("fs");
    const lines = fs
        .readFileSync("./javascript_2015/inputs/day3.txt", { encoding: "utf-8" })
        .split("")
        .map(line => line.trim());

    let grid = [0, 0];
    let roboGrid = [0, 0];
    let visited = new Set();
    visited.add(`0x0`);


    for (let i = 0; i < lines.length; i++) {
        if (lines[i] == '^') {
            if (i  % 2 === 0) {
                grid = [grid[0], grid[1] - 1];

            } else {
                roboGrid = [roboGrid[0], roboGrid[1] - 1];
            }
        }

        if (lines[i] == 'v') {
            if (i  % 2 === 0) {
                grid = [grid[0], grid[1] + 1];
            }
            else {
                roboGrid = [roboGrid[0], roboGrid[1] + 1];
            }
        }
        if (lines[i] == '>') {
            if (i  % 2 === 0) {
                grid = [grid[0] + 1, grid[1]];
            } else {
                roboGrid = [roboGrid[0] + 1, roboGrid[1]];
            }
        }
        if (lines[i] == '<') {
            if (i  % 2 === 0) {
                grid = [grid[0] - 1, grid[1]];
            } else {
                roboGrid = [roboGrid[0] - 1, roboGrid[1]];
            }
        }

        if (i  % 2 === 0) {
            visited.add(`${grid[0]}x${grid[1]}`);
        } else {
            visited.add(`${roboGrid[0]}x${roboGrid[1]}`);
        }
    }
    console.log(`Part 2: ${visited.size}`);
}



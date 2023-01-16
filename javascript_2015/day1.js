const { on } = require("events");

main();

function main() {
    const fs = require("fs");
    const lines = fs
        .readFileSync("./javascript_2015/inputs/day1.txt", { encoding: "utf-8" })
        .split("");

    var floor = 0;
    var part2 = 0;
    var onetime= true;
    for (let i = 0; i < lines.length; i++) {
        if (lines[i] == '(') {
            floor++;
        } if(lines[i] == ')') {
            floor--;
        }
        if(floor == -1 && onetime){
            part2 = i+1;
            onetime = false;
        }
    }
    console.log(`Part 1: ${floor}`);
    console.log(`Part 2: ${part2}`);


}
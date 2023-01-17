run();

function run() {
    const fs = require("fs");
    const lines = fs
    .readFileSync("./javascript_2015/inputs/day2.txt", { encoding: "utf-8" })
    .split("\n")
        .map(line => line.trim());
    var part1 = 0;
    let part2 = 0;

    for (let i = 0; i < lines.length; i++) {
        var parsed = lines[i].split("x");
        const a = parsed[0] * parsed[1];
        const b = parsed[0] * parsed[2];
        const c = parsed[1] * parsed[2];
        part1 += (2 * a) + (2 * b) + (2 * c) + Math.min(a, b, c);


        const a2 = parseInt(parsed[0]) + parseInt(parsed[0]) + parseInt(parsed[1]) + parseInt(parsed[1]);
        const b2 = parseInt(parsed[0]) + parseInt(parsed[0]) + parseInt(parsed[2]) + parseInt(parsed[2]);
        const c2 = parseInt(parsed[1]) + parseInt(parsed[1]) + parseInt(parsed[2]) + parseInt(parsed[2]);

        let min = Math.min(a2, b2, c2);
        let ribbon =  parseInt(parsed[0]) * parseInt(parsed[1]) * parseInt(parsed[2]) 
        part2 += (min + ribbon);
    }
    console.log(part1);
    console.log(part2);

}


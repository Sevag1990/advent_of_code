
//runPart1();
runPart2();

function runPart1() {
    var niceStrings = 0;

    const fs = require("fs");
    const lines = fs
        .readFileSync("./javascript_2015/inputs/day5.txt", { encoding: "utf-8" })
        .split("\n")
        .map(line => line.trim());
    const VOWELS = ['a', 'e', 'i', 'o', 'u'];
    const RESTRICTED_LETTERS = ['ab', 'cd', 'pq', 'xy'];
    const LETTERS = 'abcdefghijklmnopqrstuvwxyz'.split('').map(item => item + item);

    for (let i = 0; i < lines.length; i++) {
        let word = lines[i].split("");
        let prop1, prop2 = false;
        let prop3 = true;

        for (let x = 0; x < word.length; x++) {
            if (RESTRICTED_LETTERS.includes(`${word[x]}${word[x + 1]}`)) {
                prop3 = false;
            }
        }
        for (let x = 0; x < word.length; x++) {
            if (LETTERS.includes(`${word[x]}${word[x + 1]}`)) {
                prop2 = true;
            }
        }

        let string_vowels = lines[i].split('').filter(c => VOWELS.includes(c))
        if (string_vowels.length >= 3) {
            prop1 = true;
        }
        if (prop1 && prop2 && prop3) {
            niceStrings++;
        }
    }

    console.log(`Part 1: ${niceStrings}`);
}


function runPart2() {
    var niceStrings = 0;

    const fs = require("fs");

    const LETTERS = 'abcdefghijklmnopqrstuvwxyz'.split('').map(item => item + item);
    const lines = fs
        .readFileSync("./javascript_2015/inputs/day5.txt", { encoding: "utf-8" })
        .split("\n")
        .map(line => line.trim());


    for (let i = 0; i < lines.length; i++) {
        let word = lines[i].split("");
        let prop1, prop2 = false;

        for (let x = 0; x < word.length; x++) {
            if (LETTERS.includes(`${word[x]}${word[x + 2]}`)) {
                prop1 = true;
            }
        }
        if (/([a-z]{2})[a-z]*\1/.test(lines[i])) {
            prop2 = true;
        }

        if (prop1 && prop2) {
            niceStrings++;
        }
    }

    console.log(`Part 2: ${niceStrings}`);
}
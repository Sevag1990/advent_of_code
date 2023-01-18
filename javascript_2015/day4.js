
runPart1();
runPart2();

function runPart1() {
    let counter = 0;
    const input = "yzbqklnj";
    let includes5Zeros = false;
    var crypto = require('crypto');

    while (!includes5Zeros) {
        let md5 = cryptMD5(`${input}${counter}`,crypto);
        if (md5.slice(0, 5) === '00000') {
            includes5Zeros = true;
            break;
        }
        counter++;
    }
    console.log(`Part 1: ${counter}`);
}


function runPart2() {
    let counter = 0;
    const input = "yzbqklnj";
    let includes5Zeros = false;
    var crypto = require('crypto');

    while (!includes5Zeros) {
        let md5 = cryptMD5(`${input}${counter}`,crypto);
        if (md5.slice(0, 6) === '000000') {
            includes5Zeros = true;
            break;
        }
        counter++;
    }
    console.log(`Part 2: ${counter}`);
}


function cryptMD5(data,crypto) {
    return crypto.createHash("md5").update(data).digest("hex");
}
const fs = require("fs");

const printData = (err, data) => {
    if (err) throw err;
    console.log(data);
}

fs.readFile("file.md", "utf-8", printData);

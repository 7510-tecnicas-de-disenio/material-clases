"use strict";

const fs = require("fs");

fs.readFile("file.md", "utf-8", (err, data) => {
  if (err) throw err;
  console.log(data);
});

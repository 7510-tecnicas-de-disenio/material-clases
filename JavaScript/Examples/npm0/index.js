"use strict";

const express = require('express');
const app = express();

app.get('/', function (req, res) {
  res.send('Hello World!');
});

app.get('/nodejs', function (req, res) {
    res.send('Hello NodeJS!');
  });

app.listen(3010, function () {
  console.log('Example app listening on port 3000!');
});

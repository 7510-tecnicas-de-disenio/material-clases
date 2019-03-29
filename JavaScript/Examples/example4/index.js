"use strict";

let promise = new Promise(function(resolve, reject) {
  setTimeout(() => resolve("done!"), 1000);
});

console.log("promise created, will execute in 1 second...");

promise.then(
  result => console.log(result),
  error => console.log(error)
);
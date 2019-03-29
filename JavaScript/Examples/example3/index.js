"use strict";

let officers = [
    { id: 20, name: "Captain Piett", age: 17 },
    { id: 24, name: "General Veers", age: 54 },
    { id: 56, name: "Admiral Ozzel", age: 47 },
    { id: 88, name: "Commander Jerjerrod", age: 62 }
];

let officersIds = officers.map(officer => officer.id);

console.log(`officersIds ${JSON.stringify(officersIds)}`);

let officersSumAges = officers.reduce((accumulator, officer) => {
    return accumulator + officer.age;
}, 0);

console.log(`officersSumAges ${JSON.stringify(officersSumAges)}`);

let officersAdults = officers.filter(officer => officer.age > 18);

console.log(`officersAdults ${JSON.stringify(officersAdults)}`);
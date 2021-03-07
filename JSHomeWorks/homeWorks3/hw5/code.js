// Homework 5: objects

const initData1 = { username: 'Hacker12', password: '*&3nasgss@b38s9' }
const initData2 = { email: 'hacker12@mail.com', address: 'Petrushevycha 3, Lviv, Ukraine' }

// You have to create variable with name compiledObject

// TYPE YOUR CODE ONLY HERE
const {password, ...compiledObject} = Object.assign(initData1,initData2);

// EXPECTED RESULT (don't touch code below)
console.log(compiledObject) // { username: 'Hacker12', email: 'hacker12@mail.com', address: 'Petrushevycha 3, Lviv, Ukraine' }

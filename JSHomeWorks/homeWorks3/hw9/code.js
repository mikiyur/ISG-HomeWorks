// Homework 9: SET, arrays, functions

// don't change this array
const initArray = ['Ivan', 'Ihor', 'Vasyl', 'Oleh', 'Vasyl', 'Petro', 'Ihor', 'Ihor', 'Petro'];

function getUniqueArray(array) {
  return Array.from(new Set(array));
}

// EXPECTED RESULT
console.log(getUniqueArray(initArray)) // ['Ivan', 'Ihor', 'Vasyl', 'Oleh', 'Petro']

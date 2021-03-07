// Homework 1: arrays, functions and string prototype methods

// don't change this array
const carBrands = ['BMW', 'OPEL', 'AUDI', 'VOLKSWAGEN', 'FERRARI'];

function getBrandFromArray(brandsArray, index) {
  return 'Brand: ' + brandsArray[brandsArray.length - index - 1].toLowerCase()
}

// EXPECTED RESULT (don't touch code below)

const resultA = getBrandFromArray(carBrands, 0)
console.log(resultA) // Brand: ferrari

const resultB = getBrandFromArray(carBrands, 2)
console.log(resultB) // Brand: audi

const resultC = getBrandFromArray(carBrands, 4)
console.log(resultC) // Brand: bmw

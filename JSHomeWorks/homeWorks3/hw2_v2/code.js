// Homework 2: arrays, functions, closures

// don't change this array
const carBrands = ['BMW', 'OPEL', 'AUDI'];

function makeBrandReturnFunction() {
    let counter = 0;

    function getBrand() {
        return carBrands[counter++ % 3];
    }

    return getBrand;
}

// EXPECTED RESULT (don't touch code below)

const getBrand = makeBrandReturnFunction();
const resultA = getBrand()
console.log(resultA) // BMW

const resultB = getBrand()
console.log(resultB) // OPEL

const resultC = getBrand()
console.log(resultC) // AUDI

const resultD = getBrand()
console.log(resultD) // BMW

const resultE = getBrand()
console.log(resultE) // OPEL

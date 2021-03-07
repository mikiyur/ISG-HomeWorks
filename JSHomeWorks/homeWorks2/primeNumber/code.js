// Homework 2: -Вивести всі прості числа (діляться тільки на себе і на 1), від k до n (k ... n)
function getPrimeNumbers(k, n) {
    let arr = []
    for (let i = k; i < n; i++) {
        if (checkPrime(i)) {
            arr.push(i)
        }
    }
    return arr;
}

function checkPrime(i) {
    if (i >= 0 && i <= 3) {
        return i;
    }
    for (let j = 2; j < Math.sqrt(i+1); j++) {
        if (i % j === 0) {
            return;
        }
    }
    return i;
}

console.log(getPrimeNumbers(0, 125))

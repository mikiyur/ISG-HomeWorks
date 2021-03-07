// Homework 3: functions, objects, string prototype methods

// don't change this object
const user = {
  firstName: 'Franklin',
  lastName: 'White',
  email: 'franklin.white@gmail.com',
}

function getUserDataStringByFormat(format) {
    let arrayOfStrings = format.split(', ')
    let result = ''
    for (let str of arrayOfStrings){
        result += user[str] + ', '
    }
    return result.slice(0,result.length - 2)
}

// EXPECTED RESULT (don't touch code below)

const resultA = getUserDataStringByFormat('firstName, email')
console.log(resultA) // Franklin, franklin.white@gmail.com

const resultB = getUserDataStringByFormat('firstName, lastName')
console.log(resultB) // Franklin, White

const resultC = getUserDataStringByFormat('email, firstName, lastName')
console.log(resultC) // franklin.white@gmail.com, Franklin, White
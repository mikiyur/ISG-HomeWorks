// Homework 4: functions, objects, Date

// You have to create this function getObjectWithDate and it will return an object


// TYPE YOUR CODE ONLY HERE
function getObjectWithDate (){
    let obj = {
        currentDay : `0${new Date().getDay()}/0${new Date().getMonth()}`
    };
    return Object.assign(obj,...[...arguments]);
}

// EXPECTED RESULT (don't touch code below) You have to create this function getObjectWithDate
// and it will return an object
const resultA = getObjectWithDate({ firstName: 'John' }, { phoneNumber: 189920001 })
console.log(resultA) // { currentDay: '27/02', firstName: 'John', phoneNumber: 189920001 }

const resultB = getObjectWithDate({ id: 9188 }, { firstName: 'Martin' }, { email: 'martin.112@gmail.com' })
console.log(resultB) // { currentDay: '27/02', id: 9188, firstName: 'Martin', email: 'martin.112@gmail.com' }

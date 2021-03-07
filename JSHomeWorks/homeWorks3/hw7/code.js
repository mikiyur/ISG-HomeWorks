// Homework 7: objects

// don't change this object
const initData = {
    firstName: 'Franklin',
    lastName: 'White',
    email: 'franklin.white@gmail.com',
    address: {
        city: 'Lviv',
        postalCode: 81000,
    },
    cars: [
        {
            brand: 'Mitsubishi',
            plateNumber: 'BC0293AO'
        },
        {
            brand: 'Toyota',
            plateNumber: 'BC9932AI',
            gear: {
                type: 'Automatic'
            }
        }
    ]
}

// ADD ONLY ONE LINE OF CODE
const {email,
        cars: [{brand: firstCar, plateNumber: firstCarPlateNumber},
        {gear: {type: secondCarGearType}}],
        address: {postalCode}} = initData;


// EXPECTED RESULT
console.log(email) // 'franklin.white@gmail.com'
console.log(firstCar) // 'Mitsubishi'
console.log(firstCarPlateNumber) // 'BC0293AO'
console.log(postalCode) // 81000
console.log(secondCarGearType) // 'Automatic'

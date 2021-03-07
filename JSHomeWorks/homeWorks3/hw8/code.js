// Homework 8: objects, strings

// don't change this object
const initData = {
    firstName: 'Franklin',
    lastName: 'White',
    postalCode: 81000,
    email: 'franklin.white@gmail.com',
    address: 'Lviv',
    cars: []
}

function getUpperCasedObjectData() {
   for (let key in initData){
       if (initData.hasOwnProperty(key)&& typeof initData[key] === 'string'){
           initData[key] = initData[key].toUpperCase()
       }
   }
   return initData;
}

// EXPECTED RESULT
console.log(getUpperCasedObjectData())
/*
{
  firstName: 'FRANKLIN',
  lastName: 'WHITE',
  postalCode: 81000,
  email: 'FRANKLIN.WHITE@GMAIL.COM',
  address: 'LVIV',
  cars: []
}
*/
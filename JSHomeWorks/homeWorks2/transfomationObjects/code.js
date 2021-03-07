// Homework 3: Об"єкти :
//  Зробити з масива об"єкт
// // на вході масив
// var arr = [
//  {name: 'width', value: 10},
//  {name: 'height', value: 20}
// ]
// // на виході об"єкт
// {width: 10, height: 20}

function arrayToObject(arr) {
    const newObj = {}
    arr.forEach(obj => newObj[obj.name] = obj.value)
    return newObj
}

const arr = [
    {name: 'width', value: 10},
    {name: 'height', value: 20},
    {name: 'length', value: 30}
    ]

console.log(arrayToObject(arr));
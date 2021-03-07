// Homework 1: Числа від 1 до 100 лежать в масиві, вони хаотично перемішані,
// звідти вилучили одне число, треба знайти, що це за число
function findAbsentNumber(arr) {
    let set = new Set(arr)
    for (let i = 1; i <= 100; i++) {
        set.add(i)
        if (set.size === 100){
            return i
        }
    }
}


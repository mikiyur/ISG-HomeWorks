// Homework 6: functions, Date, strings

function getAgeUpToHours(birthdayDate) {
    const nowDate = new Date()
    let years =  nowDate.getFullYear() - birthdayDate.getFullYear()-1
    birthdayDate.setFullYear(nowDate.getFullYear()-1)
    let days  = (nowDate.getTime() - birthdayDate.getTime())/86400000
    birthdayDate.setMonth(nowDate.getMonth())
    birthdayDate.setDate(nowDate.getDate())
    birthdayDate.setFullYear(nowDate.getFullYear())
    let ours = (nowDate.getTime() - birthdayDate.getTime())/3600000
    return`${years.toFixed(0)} years, ${days.toFixed(0)} days, ${ours.toFixed(0)} ours`
}

// EXPECTED RESULT
console.log(getAgeUpToHours(new Date('March 15, 1997 21:15'))) // 23 years, 348 days, 23 hours
console.log(getAgeUpToHours(new Date('October 04, 1987 13:00 '))) // You can paste you birth date and look how old are you ;)

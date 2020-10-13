const lastDayOfMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

export function getLastDayOfMonth(year, month) {
  if (month === 2) {
    if (year % 400 === 0) {
      return 29;
    } else if (year % 4 === 0 && year % 100 !== 0) {
      return 29;
    }
  }
  return lastDayOfMonth[month - 1];
}

const NEXT_MONTH = "date-reducer/NEXT_MONTH";
const PREV_MONTH = "date-reducer/PREV_MONTH";

//ACTIONS
export const next_month = () => ({ type: NEXT_MONTH });
export const prev_month = () => ({ type: PREV_MONTH });

//Reducer
const initialState = {
  currentYear: new Date().getFullYear(),
  currentMonth: new Date().getMonth() + 1,
  currentDay: new Date().getDay(),
  firstDayOfWeek: getFirstDayOfWeek(
    new Date().getFullYear(),
    new Date().getMonth()
  ),
};

function getFirstDayOfWeek(year, month) {
  return new Date(year.toString() + "-" + month.toString() + "-1").getDay();
}

function dateReducer(state = initialState, action) {
  let resultYear = state.currentYear;
  let resultMonth = state.currentMonth;

  switch (action.type) {
    case NEXT_MONTH:
      resultMonth = state.currentMonth + 1;
      break;
    case PREV_MONTH:
      resultMonth = state.currentMonth - 1;
      break;
  }

  if (resultMonth > 12) {
    resultMonth = 1;
    resultYear++;
  } else if (resultMonth < 1) {
    resultMonth = 12;
    resultYear--;
  }

  return {
    ...state,
    currentMonth: resultMonth,
    currentYear: resultYear,
    firstDayOfWeek: getFirstDayOfWeek(resultYear, resultMonth),
  };
}

export default dateReducer;

const NEXT_MONTH = "month-manager/NEXT_MONTH";
const PREV_MONTH = "month-manager/PREV_MONTH";

//ACTIONS
export const next_month = () => ({ type: NEXT_MONTH });
export const prev_month = () => ({ type: PREV_MONTH });

//Reducer
const initialState = {
  currentYear: new Date().getFullYear(),
  currentMonth: new Date().getMonth(),
};

function monthManager(state = initialState, action) {
  let resultYear = state.currentYear;
  let resultMonth = state.currentMonth;

  switch (action.type) {
    case NEXT_MONTH:
      resultMonth = state.currentMonth + 1
      break
    case PREV_MONTH:
      resultMonth = state.currentMonth - 1
      break
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
  }
}

export default monthManager;

const NEXT_MONTH = "date-reducer/NEXT_MONTH";
const PREV_MONTH = "date-reducer/PREV_MONTH";

//ACTIONS
export const next_month = () => ({ type: NEXT_MONTH });
export const prev_month = () => ({ type: PREV_MONTH });

//Reducer
const initialState = {
  currentDate: new Date(),
};

function dateReducer(state = initialState, action) {
  let resultDate = state.currentDate;

  switch (action.type) {
    case NEXT_MONTH:
      resultDate = new Date(
        resultDate.getFullYear(),
        resultDate.getMonth() + 1,
        resultDate.getDate()
      );
      break;
    case PREV_MONTH:
      resultDate = new Date(
        resultDate.getFullYear(),
        resultDate.getMonth() - 1,
        resultDate.getDate()
      );
      break;
  }

  return {
    ...state,
    currentDate: resultDate,
  };
}

export default dateReducer;

const NEXT_MONTH = "month-manager/NEXT_MONTH";
const PREV_MONTH = "month-manager/PREV_MONTH";

//ACTIONS
export const next_month = () => ({ type: NEXT_MONTH });
export const prev_month = () => ({ type: PREV_MONTH });

//Reducer
const initialState = {
  number: 0,
};

function monthManager(state = initialState, action) {
  switch (action.type) {
    case NEXT_MONTH:
      return {
        number: state.number + 1,
      };
    case PREV_MONTH:
      return {
        number: state.number - 1,
      };
    default:
      return state;
  }
}

export default monthManager;

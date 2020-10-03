const INCREMENT = "counter/INCREMENT";
const DECREMENT = "counter/DECREMENT";

//ACTIONS
export const increment = () => ({ type: INCREMENT });
export const decrement = () => ({ type: DECREMENT });

//Reducer
const initialState = {
  number: 0,
};

function counter(state = initialState, action) {
  switch (action.type) {
    case INCREMENT:
      return {
        number: state.number + 1,
      };
    case DECREMENT:
      return {
        number: state.number - 1,
      };
    default:
      return state;
  }
}

export default counter;

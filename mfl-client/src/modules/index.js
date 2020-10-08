import { combineReducers } from "redux";
import monthManager from "./date-reducer";

const rootReducer = combineReducers({
  monthManager,
});

export default rootReducer;
